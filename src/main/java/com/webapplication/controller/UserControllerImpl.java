package com.webapplication.controller;

import com.webapplication.authentication.Authenticator;
import com.webapplication.dao.ParentRepository;
import com.webapplication.dao.ProviderRepository;
import com.webapplication.dao.UserRepository;
import com.webapplication.dto.user.*;
import com.webapplication.entity.ParentEntity;
import com.webapplication.entity.ProviderEntity;
import com.webapplication.entity.UserEntity;
import com.webapplication.error.user.UserError;
import com.webapplication.error.user.UserLogInError;
import com.webapplication.exception.NotAuthorizedException;
import com.webapplication.exception.ValidationException;
import com.webapplication.exception.user.*;
import com.webapplication.mapper.UserMapper;
import com.webapplication.validator.user.UserRequestValidator;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;


@Component
public class UserControllerImpl implements UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProviderRepository providerRepository;
    @Autowired
    private ParentRepository parentRepository;
    @Autowired
    private UserRequestValidator userRequestValidator;
    @Autowired
    private Authenticator authenticator;
    @Autowired
    private UserMapper userMapper;


    public UserLogInResponseDto login(@RequestBody UserLogInRequestDto userLogInRequestDto) throws Exception {
        userRequestValidator.validate(userLogInRequestDto);

        UserEntity user = userRepository.findUsersByEmail(userLogInRequestDto.getEmail());

        //Null credentials validation
        Optional.ofNullable(user).orElseThrow(() -> new NotAuthenticatedException(UserLogInError.INVALID_CREDENTIALS));


        //Password validation with salt callback to be used later. Using dummy validation below!
        //        if (!validatePassword(userLogInRequestDto.getPassword(), user.getPassword(), user.getSalt()))
//            throw new NotAuthenticatedException(UserLogInError.INVALID_CREDENTIALS);

        //Dummy password validation!

        if(!user.getPassword().equals(userLogInRequestDto.getPassword()))
            throw new NotAuthenticatedException(UserLogInError.INVALID_CREDENTIALS);
        //Not verified validation
        if (!user.getValidated())
            throw new EmailUnverifiedException(UserLogInError.USER_NOT_EMAIL_VERIFIED);

        SessionInfo session = new SessionInfo(user.getId(), DateTime.now().plusMinutes(Authenticator.SESSION_TIME_OUT_MINUTES), user.getRole());
        UUID authToken = authenticator.createSession(session);

        UserLogInResponseDto userLogInResponseDto = new UserLogInResponseDto();
        userLogInResponseDto.setUserId(user.getId());
        userLogInResponseDto.setAuthToken(authToken);
        userLogInResponseDto.setRole(user.getRole());
        return userLogInResponseDto;

    }

    @Override
    public UserResponseDto getUser(@RequestHeader UUID authToken, @PathVariable Integer userId) throws Exception {
        Optional.ofNullable(authToken).orElseThrow(() -> new ValidationException(UserError.MISSING_DATA));
        Optional.ofNullable(userId).orElseThrow(() -> new ValidationException(UserError.MISSING_DATA));

        //Get Active Session
        SessionInfo sessionInfo = authenticator.getSession(authToken);
        Optional.ofNullable(sessionInfo).orElseThrow(() -> new NotAuthenticatedException(UserError.NOT_AUTHENTICATED));
        sessionInfo.setDate(DateTime.now().plusMinutes(Authenticator.SESSION_TIME_OUT_MINUTES));

        //Get UserEntity
        UserEntity user = userRepository.findUsersById(userId);

        //Validate Authorization
        if (!userId.equals(sessionInfo.getUserId()))
            throw new NotAuthorizedException(UserError.UNAUTHORIZED);


        return  userMapper.userToUserResponse(user);
    }

    @Override
    public UserSignUpResponseDto signUp(@RequestBody UserSignUpRequestDto userSignUpRequestDto) throws Exception {
        UserEntity userEntity= userMapper.userEntityFromUserDto(userSignUpRequestDto);
        userEntity.setValidated(true);
        if (userSignUpRequestDto.getRole().equals("parent")){//todo make enump parent
           saveParent(userEntity,userSignUpRequestDto.getParent());
        }
        else{
            saveProvider(userEntity,userSignUpRequestDto.getProvider());
        }
        return null;
    }

    private void saveProvider(UserEntity userEntity, ProviderRequestDto providerRequestDto) {
        ProviderEntity provider = userMapper.providerEntityFromProviderDto(providerRequestDto);
        provider.setUser(userEntity);
        userRepository.saveAndFlush(userEntity);
        providerRepository.saveAndFlush(provider);
    }

    private void saveParent(UserEntity userEntity,ParentRequestDto parentRequestDto) {
        ParentEntity parent = userMapper.parentEntityFromParentDto(parentRequestDto);
        parent.setUser(userEntity);
        userRepository.saveAndFlush(userEntity);  //todo check if you can save them with one call
        parentRepository.saveAndFlush(parent);
    }


    // Password validation method to be used later when there's salt and registration is done

   /* private Boolean validatePassword(String attemptedPassword, String password, String saltStored) throws Exception {
        byte[] salt = Base64.decodeBase64(saltStored.getBytes());
        String algorithm = "PBKDF2WithHmacSHA1";
        int derivedKeyLength = 160;
        int iterations = 20000;
        KeySpec spec = new PBEKeySpec(attemptedPassword.toCharArray(), salt, iterations, derivedKeyLength);
        SecretKeyFactory f = SecretKeyFactory.getInstance(algorithm);
        String encodedAttemptedPassword = new String(Base64.encodeBase64(f.generateSecret(spec).getEncoded()));
        return password.equals(encodedAttemptedPassword);
    } */


    // EXCEPTION HANDLERS!

    @ExceptionHandler(ValidationException.class)
    private void invalidAttributes(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(NotAuthenticatedException.class)
    private void userNotFound(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.UNAUTHORIZED.value());
    }

    @ExceptionHandler({UserAlreadyExistsException.class, UserAlreadyVerifiedException.class, EmailAlreadyInUseException.class})
    private void conflict(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.CONFLICT.value());
    }

    @ExceptionHandler(UserNotFoundException.class)
    private void resourceNotFound(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler({NotAuthorizedException.class, ForbiddenException.class, EmailUnverifiedException.class})
    private void forbiddenAction(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.FORBIDDEN.value());
    }

    @ExceptionHandler(Exception.class)
    private void genericError(HttpServletResponse response) throws IOException {//todo we do not see errors in console
        response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}
