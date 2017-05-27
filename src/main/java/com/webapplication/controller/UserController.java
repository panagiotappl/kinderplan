package com.webapplication.controller;

import com.webapplication.dto.user.UserLogInRequestDto;
import com.webapplication.dto.user.UserLogInResponseDto;
import com.webapplication.dto.user.UserResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api")
public interface UserController {
//
//    @RequestMapping(path= "/login")
//    UserLogInResponseDto login(UserLogInRequestDto userLogInRequestDto) throws BadRequestException;
//
//    @RequestMapping(path= "/providersignup")
//    UserSignUpResponseDto providerSignUp(UserSignUpRequestDto userSignUpRequestDto) throws BadRequestException;
//
//    @RequestMapping(path= "/parentsignup")
//    UserSignUpResponseDto parentSignUp(UserSignUpRequestDto userSignUpRequestDto) throws BadRequestException;
//
//    @RequestMapping(path= "/getuser/{userId}")
////    UserResponseDto getuser(@PathVariable int userId) throws BadRequestException;
//
//    @RequestMapping(path="/user", method = RequestMethod.GET)
//    ResponseEntity listUser();
//
//    @RequestMapping(path="/user/{id}", method = RequestMethod.GET)
//    ResponseEntity  listUser(@PathVariable(value = "id") String id);
//
//    @RequestMapping(path="/user", method = RequestMethod.POST)
//    ResponseEntity  listUser(@RequestBody User user);
//
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    @ResponseBody
//    ResponseEntity login(Principal principal);
//
//    @RequestMapping(value = "/user", method = RequestMethod.GET)
//    @ResponseBody
//    ResponseEntity getUser(Principal principal);

    @RequestMapping(path = "/login", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    UserLogInResponseDto login(UserLogInRequestDto userLogInRequestDto) throws Exception;

    @RequestMapping(path = "/user/{userId}", method = RequestMethod.GET, produces = "application/json")
    UserResponseDto getUser(@RequestHeader UUID authToken, @PathVariable Integer userId) throws Exception;
}