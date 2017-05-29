package com.webapplication.validator.user;


import com.webapplication.dto.user.UserLogInRequestDto;
import com.webapplication.dto.user.UserSignUpRequestDto;
import com.webapplication.exception.ValidationException;
import com.webapplication.validator.ValidatorWrapper.UserRequestValidatorWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRequestValidator implements UserRequestValidatorWrapper {

    @Autowired
    private UserLogInValidator userLogInValidator;

    @Autowired
    private UserSignUpValidator userSignUpValidator;


    @Override
    public void validate(UserLogInRequestDto userLogInRequestDto) throws ValidationException {
        userLogInValidator.validate(userLogInRequestDto);
    }

    @Override
    public void validate(UserSignUpRequestDto userSignUpRequestDto) throws ValidationException {
        userSignUpValidator.validate(userSignUpRequestDto);
    }


}
