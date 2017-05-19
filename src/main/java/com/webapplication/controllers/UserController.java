package com.webapplication.controllers;

import com.webapplication.dto.UserLogInResponseDto;
import com.webapplication.dto.UserLoginRequestDto;
import com.webapplication.dto.UserSignUpRequestDto;
import com.webapplication.dto.UserSignUpResponseDto;
import com.webapplication.exceptions.BadRequestException;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(path = "/api")
public interface UserController {

    @RequestMapping(path= "/login")
    UserLogInResponseDto login(UserLoginRequestDto userLogInRequestDto) throws BadRequestException;


    @RequestMapping(path= "/signup")
    UserSignUpResponseDto signup(UserSignUpRequestDto userSignUpRequestDto) throws BadRequestException;
}