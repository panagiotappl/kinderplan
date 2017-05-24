package com.webapplication.controllers;

import com.webapplication.entities.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public interface UserController {
//
//    @RequestMapping(path= "/login")
//    UserLogInResponseDto login(UserLoginRequestDto userLogInRequestDto) throws BadRequestException;
//
//    @RequestMapping(path= "/providersignup")
//    UserSignUpResponseDto providerSignUp(UserSignUpRequestDto userSignUpRequestDto) throws BadRequestException;
//
//    @RequestMapping(path= "/parentsignup")
//    UserSignUpResponseDto parentSignUp(UserSignUpRequestDto userSignUpRequestDto) throws BadRequestException;
//
//    @RequestMapping(path= "/getuser/{userId}")
//    UserResponseDto getuser(@PathVariable int userId) throws BadRequestException;

    @RequestMapping(path="/user", method = RequestMethod.GET)
    ResponseEntity listUser();

    @RequestMapping(path="/user/{id}", method = RequestMethod.GET)
    ResponseEntity  listUser(@PathVariable(value = "id") String id);

    @RequestMapping(path="/user", method = RequestMethod.POST)
    ResponseEntity  listUser(@RequestBody Users user);
}