package com.webapplication.controller;

import com.webapplication.dao.jpaRepository.*;
import com.webapplication.entity.*;
import com.webapplication.entity.TransactionEntity;
import com.webapplication.dao.jpaRepository.ParentRepository;
import com.webapplication.dao.jpaRepository.ProviderRepository;
import com.webapplication.dao.jpaRepository.UserRepository;
import com.webapplication.dao.jpaRepository.TransactionRepository;
import com.webapplication.entity.TransactionEntity;
import com.webapplication.error.user.ProviderCommentSubmitError;
import com.webapplication.mapper.CommentProviderMapper;
import com.webapplication.validator.user.ProviderCommentValidator;
import org.apache.tomcat.util.codec.binary.Base64;
import org.joda.time.DateTime;

import com.webapplication.authentication.Authenticator;
import com.webapplication.dto.user.*;
import com.webapplication.error.user.UserError;
import com.webapplication.error.user.UserLogInError;
import com.webapplication.exception.NotAuthorizedException;
import com.webapplication.exception.ValidationException;
import com.webapplication.exception.user.*;
import com.webapplication.mapper.UserMapper;
import com.webapplication.validator.user.UserRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.sql.Timestamp;
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
    private TransactionRepository transactionRepository;
    @Autowired
    private CommentProviderRepository commentProviderRepository;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CommentProviderMapper commentProviderMapper;

    @Autowired
    private UserRequestValidator userRequestValidator;
    @Autowired
    private ProviderCommentValidator providerCommentValidator;

    @Autowired
    private Authenticator authenticator;


    public UserLogInResponseDto login(@RequestBody UserLogInRequestDto userLogInRequestDto) throws Exception {
        userRequestValidator.validate(userLogInRequestDto);

        UserEntity user = userRepository.findUsersByEmail(userLogInRequestDto.getEmail());
        System.out.println(user);
        //Null credentials validation
        Optional.ofNullable(user).orElseThrow(() -> new NotAuthenticatedException(UserLogInError.INVALID_CREDENTIALS));


       // Password validation with salt callback to be used later. Using dummy validation below!
        if (!validatePassword(userLogInRequestDto.getPassword(), user.getPassword(), user.getSalt()))//TODO FIX THIS
            throw new NotAuthenticatedException(UserLogInError.INVALID_CREDENTIALS);

//        //Dummy password validation!
//
//        if(!user.getPassword().equals(userLogInRequestDto.getPassword()))
//            throw new NotAuthenticatedException(UserLogInError.INVALID_CREDENTIALS);

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
        SessionInfo sessionInfo = authenticator.checkUpdateSession(authToken);

        //Get UserEntity
        UserEntity user = userRepository.findUsersById(userId);

        //Validate Authorization
        if (!userId.equals(sessionInfo.getUserId()))
            throw new NotAuthorizedException(UserError.UNAUTHORIZED);

        ParentEntity parent = null;
        ProviderEntity provider = null;

        if(user.getRole().equals("parent"))
            parent = parentRepository.findParentByUserId(userId);
        else
            provider = providerRepository.findProviderByUserId(userId);

        return  userMapper.userToUserResponse(user, parent, provider);
    }

    @Override
    public UserSignUpResponseDto signUp(@RequestBody UserSignUpRequestDto userSignUpRequestDto) throws Exception {
        userRequestValidator.validate(userSignUpRequestDto);

        byte[] salt = createSaltForUser();
        String encodedSaltAsString = new String(Base64.encodeBase64(salt));
        String encodedPassword = encodePassword(userSignUpRequestDto.getPassword(), salt);

        UserEntity userEntity= userMapper.userEntityFromUserDto(userSignUpRequestDto, encodedPassword, encodedSaltAsString);
        userEntity.setValidated(true);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        userEntity.setCreatedDate(timestamp);



        if (userSignUpRequestDto.getRole().equals("parent")){//todo make enump parent
           saveParent(userEntity, userSignUpRequestDto.getParent());
        }
        else{
            saveProvider(userEntity,userSignUpRequestDto.getProvider());
        }
        UserSignUpResponseDto response = new UserSignUpResponseDto(HttpStatus.OK,"User is registered succesfully");
        return  response;
    }

    @Override
    public PayResponseDto pay(@RequestHeader UUID authToken, @RequestBody  PayRequestDto payRequestDto) throws Exception{
        System.out.print(payRequestDto.getPoints() + payRequestDto.getUserId());
        Integer userId = payRequestDto.getUserId();
        Optional.ofNullable(authToken).orElseThrow(() -> new ValidationException(UserError.MISSING_DATA));
        Optional.ofNullable(userId).orElseThrow(() -> new ValidationException(UserError.MISSING_DATA));

        //Get Active Session
        SessionInfo sessionInfo = authenticator.checkUpdateSession(authToken);

        //Get UserEntity
        UserEntity user = userRepository.findUsersById(userId);

        //Validate Authorization
        if (!userId.equals(sessionInfo.getUserId()))
            throw new NotAuthorizedException(UserError.UNAUTHORIZED);


        //Only parents can buy points
        if(!user.getRole().equals("parent"))
            throw new NotAuthorizedException(UserError.UNAUTHORIZED);

        ParentEntity parent = parentRepository.findParentByUserId(userId);
        parent.setPoints(parent.getPoints() + payRequestDto.getPoints());
        parentRepository.save(parent);

        addTransaction(payRequestDto.getTransactionDto(), payRequestDto.getPoints(), parent);

        return null;
    }



    private void addTransaction(TransactionDto transactionDto, Integer amount, ParentEntity parent){
        TransactionEntity transactionEntity = userMapper.transactionEntityFromTransactionDto(transactionDto, amount, parent);
        transactionRepository.save(transactionEntity);

    }
    private void saveProvider(UserEntity userEntity, ProviderDto providerDto) {
        ProviderEntity provider = userMapper.providerEntityFromProviderDto(providerDto);
        provider.setUser(userEntity);
        userRepository.saveAndFlush(userEntity);
        providerRepository.saveAndFlush(provider);
    }

    private void saveParent(UserEntity userEntity, ParentDto parentDto) {


        ParentEntity parent = userMapper.parentEntityFromParentDto(parentDto);
        parent.setUser(userEntity);
        userRepository.saveAndFlush(userEntity);  //todo check if you can save them with one call
        parentRepository.saveAndFlush(parent);
    }

    @Override
    public SubmitProviderCommentResponseDto submitComment(@RequestHeader UUID authToken, SubmitProviderCommentRequestDto request) throws Exception{

        Optional.ofNullable(authToken).orElseThrow(() -> new ValidationException(UserError.MISSING_DATA));
        providerCommentValidator.validate(request);
        ParentEntity parentEntity = parentRepository.findParentByUserId(request.getUser_id());
        if (authenticator.getSession(authToken).getUserId() != parentEntity.getUser().getId()){
            throw new ValidationException(UserError.UNAUTHORIZED);
        }
        ProviderEntity providerEntity = providerRepository.findProviderById(request.getProvider_id());
        if (providerEntity == null){
            throw new ValidationException(ProviderCommentSubmitError.PROVIDER_NOT_EXISTS);
        }

        CommentProviderEntity commentProviderEntity = commentProviderMapper.commentProviderEntityFromSubmitCommentProviderDto(request, parentEntity, providerEntity);
        commentProviderEntity.setDate(new Timestamp(System.currentTimeMillis()));
        commentProviderRepository.saveAndFlush(commentProviderEntity);
        SubmitProviderCommentResponseDto response = new SubmitProviderCommentResponseDto(HttpStatus.OK, "Comment submitted successfully.");

        return response;

    }


    // Password validation method to be used later when there's salt and registration is done

   private Boolean validatePassword(String attemptedPassword, String password, String saltStored) throws Exception {
        byte[] salt = Base64.decodeBase64(saltStored.getBytes());
        String algorithm = "PBKDF2WithHmacSHA1";
        int derivedKeyLength = 160;
        int iterations = 20000;
        KeySpec spec = new PBEKeySpec(attemptedPassword.toCharArray(), salt, iterations, derivedKeyLength);
        SecretKeyFactory f = SecretKeyFactory.getInstance(algorithm);
        String encodedAttemptedPassword = new String(Base64.encodeBase64(f.generateSecret(spec).getEncoded()));
        System.out.println(password.equals(encodedAttemptedPassword));
        return password.equals(encodedAttemptedPassword);
    }


    // EXCEPTION HANDLERS!


    private byte[] createSaltForUser() throws NoSuchAlgorithmException {
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[8];
        random.nextBytes(salt);
        return salt;
    }

    private String encodePassword(String password, byte[] salt) throws Exception {
        String algorithm = "PBKDF2WithHmacSHA1";
        int derivedKeyLength = 160;
        int iterations = 20000;
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, derivedKeyLength);
        SecretKeyFactory f = SecretKeyFactory.getInstance(algorithm);
        byte[] encodedPassword = Base64.encodeBase64(f.generateSecret(spec).getEncoded());
        return new String(encodedPassword);
    }

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
