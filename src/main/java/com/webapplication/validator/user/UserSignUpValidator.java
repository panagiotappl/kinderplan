package com.webapplication.validator.user;


import com.webapplication.dao.jpaRepository.UserRepository;
import com.webapplication.dto.user.UserSignUpRequestDto;
import com.webapplication.error.user.UserLogInError;
import com.webapplication.error.user.UserRegisterError;
import com.webapplication.exception.ValidationException;
import com.webapplication.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by dimitris on 5/29/2017.
 */
@Component
public class UserSignUpValidator implements Validator <UserSignUpRequestDto>{

    @Autowired
    private UserRepository userRepository;
    @Override
    public void validate(UserSignUpRequestDto request) throws ValidationException {
        Optional.ofNullable(request).orElseThrow(() -> new ValidationException(UserRegisterError.MISSING_DATA));
        Optional.ofNullable(request.getEmail()).orElseThrow(() -> new ValidationException(UserRegisterError.MISSING_EMAIL));
        Optional.ofNullable(request.getAddress()).orElseThrow(() -> new ValidationException(UserRegisterError.MISSING_ADDRESS));
        Optional.ofNullable(request.getName()).orElseThrow(() -> new ValidationException(UserRegisterError.MISSING_NAME));
        Optional.ofNullable(request.getSurname()).orElseThrow(() -> new ValidationException(UserRegisterError.MISSING_SURNAME));
        Optional.ofNullable(request.getPassword()).orElseThrow(() -> new ValidationException(UserRegisterError.MISSING_PASSWORD));
        Optional.ofNullable(request.getRepassword()).orElseThrow(() -> new ValidationException(UserRegisterError.MISSING_REPASSWORD));
        Optional.ofNullable(request.getRole()).orElseThrow(() -> new ValidationException(UserRegisterError.MISSING_ROLE));
        if (userRepository.findUsersByEmail(request.getEmail())!=null){
            throw new ValidationException(UserRegisterError.EMAIL_ALREADY_USED);
        }
        if(!request.getPassword().equals(request.getRepassword())){
            throw new ValidationException(UserRegisterError.PASSWORDS_NOT_MATCH);
        }
    }
}
