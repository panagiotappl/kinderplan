package com.webapplication.controller;

import com.webapplication.dto.user.*;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api")
public interface UserController {

    @RequestMapping(path = "/login", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    UserLogInResponseDto login(UserLogInRequestDto userLogInRequestDto) throws Exception;

    @RequestMapping(path = "/user/{userId}", method = RequestMethod.GET, produces = "application/json")
    UserResponseDto getUser(@RequestHeader UUID authToken, @PathVariable Integer userId) throws Exception;

    @RequestMapping(path = "/signup", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    UserSignUpResponseDto signUp(UserSignUpRequestDto userSignUpRequestDto) throws Exception;

    @RequestMapping(path = "/pay", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    PayResponseDto pay(@RequestHeader UUID authToken, PayRequestDto payRequestDto) throws Exception;

    @RequestMapping(path = "/provider/submitComment", method = RequestMethod.POST, consumes = "application/json", produces="application/json")
    SubmitProviderCommentResponseDto submitComment(@RequestHeader UUID authToken, SubmitProviderCommentRequestDto request) throws Exception;
}