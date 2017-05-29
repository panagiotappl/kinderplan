package com.webapplication.validator.ValidatorWrapper;


import com.webapplication.dto.user.UserLogInRequestDto;
import com.webapplication.dto.user.UserSignUpRequestDto;
import com.webapplication.exception.ValidationException;

public interface UserRequestValidatorWrapper {

    void validate(UserLogInRequestDto userLogInRequestDto) throws ValidationException;

    void validate(UserSignUpRequestDto userSignUpRequestDto) throws ValidationException;



}
