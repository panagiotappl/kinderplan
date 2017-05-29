package com.webapplication.controller;

import com.webapplication.dto.user.*;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api")
public interface UserController {

//    @RequestMapping(path= "/providersignup")
//    UserSignUpResponseDto providerSignUp(UserSignUpRequestDto userSignUpRequestDto) throws BadRequestException;
//
//    @RequestMapping(path= "/parentsignup")
//    UserSignUpResponseDto parentSignUp(UserSignUpRequestDto userSignUpRequestDto) throws BadRequestException;


    @RequestMapping(path = "/login", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    UserLogInResponseDto login(UserLogInRequestDto userLogInRequestDto) throws Exception;

    @RequestMapping(path = "/user/{userId}", method = RequestMethod.GET, produces = "application/json")
    UserResponseDto getUser(@RequestHeader UUID authToken, @PathVariable Integer userId) throws Exception;

    @RequestMapping(path = "/signup", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    UserSignUpResponseDto signUp(UserSignUpRequestDto userSignUpRequestDto) throws Exception;
}