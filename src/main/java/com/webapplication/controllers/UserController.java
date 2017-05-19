package com.webapplication.controllers;

import com.webapplication.dto.*;
import com.webapplication.exceptions.BadRequestException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(path = "/api")
public interface UserController {

    @RequestMapping(path= "/login")
    UserLogInResponseDto login(UserLoginRequestDto userLogInRequestDto) throws BadRequestException;

    @RequestMapping(path= "/signup")
    UserSignUpResponseDto signup(UserSignUpRequestDto userSignUpRequestDto) throws BadRequestException;

    @RequestMapping(path= "/getuser/{userId}")
    UserResponseDto getuser(@PathVariable int userId) throws BadRequestException;

}