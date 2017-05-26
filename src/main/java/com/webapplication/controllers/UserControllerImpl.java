package com.webapplication.controllers;

import com.webapplication.dao.ParentRepository;
import com.webapplication.dao.ProviderRepository;
import com.webapplication.dao.UsersRepository;
import com.webapplication.dto.UserDto;
import com.webapplication.dto.UserLogInResponseDto;
import com.webapplication.entities.Users;
import com.webapplication.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

import java.util.List;

@Component
public class UserControllerImpl implements UserController {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private ProviderRepository providerRepository;
    @Autowired
    private ParentRepository parentRepository;

    @RequestMapping(path = "/user", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public ResponseEntity listUser() {
        return new ResponseEntity(usersRepository.findAll().toArray(), HttpStatus.OK);
    }

    @RequestMapping(path = "/userById", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity listUser(@RequestBody String userId) {
        return new ResponseEntity(usersRepository.findUserById(1), HttpStatus.OK);

    }

    @RequestMapping(path="/user", method = RequestMethod.POST)
    public ResponseEntity  listUser(@RequestBody Users user){
        return new ResponseEntity(usersRepository.findAll().toArray(), HttpStatus.OK);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseEntity login(Principal principal) {
        Users user = usersRepository.findUsersByEmail(principal.getName());
        ResponseEntity responseEntity = new ResponseEntity(UserMapper.fromUserToLogInResponseDto(user), HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getUser(Principal principal) {
        Users user = usersRepository.findUsersByEmail(principal.getName());
        ResponseEntity responseEntity = new ResponseEntity(UserMapper.fromUserToResponseDto(user), HttpStatus.OK);
        return responseEntity;
    }

}
