package com.webapplication.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping(path = "/api")
public interface UserController {

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public String hello();

    @RequestMapping(value = "/private", method = RequestMethod.POST)
    @ResponseBody
    public String privateArea();

    @RequestMapping(value = "/logIn", method = RequestMethod.POST)
    @ResponseBody
    public String logIn(String email,String password);

    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    @ResponseBody
    public String currentUserEmail(Principal principal);
}