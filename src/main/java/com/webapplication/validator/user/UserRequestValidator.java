package com.webapplication.validator.user;


import com.webapplication.dto.user.UserLogInRequestDto;
import com.webapplication.exception.ValidationException;
import com.webapplication.validator.ValidatorWrapper.UserRequestValidatorWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRequestValidator implements UserRequestValidatorWrapper {

    @Autowired
    private UserLogInValidator userLogInValidator;


    @Override
    public void validate(UserLogInRequestDto userLogInRequestDto) throws ValidationException {
        userLogInValidator.validate(userLogInRequestDto);
    }



}
