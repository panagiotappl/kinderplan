package com.webapplication.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(path = "/api")
public interface UserController {

    @RequestMapping(path= "/login")
    String login();

}