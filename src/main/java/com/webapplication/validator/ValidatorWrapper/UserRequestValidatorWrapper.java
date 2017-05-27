package com.webapplication.validator.ValidatorWrapper;


import com.webapplication.dto.user.UserLogInRequestDto;
import com.webapplication.exception.ValidationException;

public interface UserRequestValidatorWrapper {

    void validate(UserLogInRequestDto userLogInRequestDto) throws ValidationException;



}
