package com.webapplication.controllers;

import com.webapplication.dao.ParentRepository;
import com.webapplication.dao.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Component
public class UserControllerImpl implements UserController {

    @Override
    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    @ResponseBody
    public String currentUserEmail(Principal principal) {
        return principal.getName();
    }


    @Override
    public String hello() {
        return "Hello";
    }

    @Override
    public String privateArea() {
        return "Private";
    }

    @Override
    public String logIn(String email, String password) {
        return "LogIn";
    }

}
