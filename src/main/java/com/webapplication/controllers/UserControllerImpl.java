package com.webapplication.controllers;

import com.webapplication.dao.ParentRepository;
import com.webapplication.dao.ProviderRepository;
import com.webapplication.dao.UserRepository;
import com.webapplication.dto.*;
import com.webapplication.entities.Parents;
import com.webapplication.entities.Providers;
import com.webapplication.entities.User;
import com.webapplication.exceptions.BadRequestException;
import com.webapplication.mappers.UserMapper;
import javafx.geometry.Orientation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;


import java.security.Principal;
import java.util.List;
import java.util.UUID;

@Component
public class UserControllerImpl implements UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProviderRepository providerRepository;
    @Autowired
    private ParentRepository parentRepository;

    @Override
    @RequestMapping(path = "/login", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public UserLogInResponseDto login(@RequestBody UserLoginRequestDto userLogInRequestDto) throws BadRequestException {
        User user= new User();
        user=userRepository.findUserByEmailAndPassword(userLogInRequestDto.getEmail(),userLogInRequestDto.getPassword());
        if (user == null)
            throw new BadRequestException("User not found");
        //prepare response
        UUID generatedToken = UUID.randomUUID();
        UserLogInResponseDto userLogInResponseDto = new UserLogInResponseDto();
        userLogInResponseDto.setUserId((long) user.getId());
        userLogInResponseDto.setRole(user.getRole());
        userLogInResponseDto.setGeneratedToken(generatedToken);
        return userLogInResponseDto;
    }

    @Override
    @RequestMapping(path = "/providersignup", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public UserSignUpResponseDto providerSignUp(@RequestBody UserSignUpRequestDto userSignUpRequestDto){
        //todo check user's data
        User user =UserMapper.registerRequestToUser(userSignUpRequestDto);
        user.setRole("Provider");
        Providers provider = new Providers();
        provider.setVatNumber(0);
        provider.setCompanyName(userSignUpRequestDto.getCompanyName());
        provider.setUsersEntityByUserId(user);
        providerRepository.saveAndFlush(provider);
        System.out.println("hello");
        return null;
    }

    @Override
    @RequestMapping(path = "/parentsignup", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public UserSignUpResponseDto parentSignUp(@RequestBody UserSignUpRequestDto userSignUpRequestDto){
        //todo check user's data
        User user =UserMapper.registerRequestToUser(userSignUpRequestDto);
        user.setRole("Parent");//todo create enum for roles
        Parents parent = new Parents();
        parent.setPoints(0);
        parent.setUsersEntityByUserId(user);
        parentRepository.saveAndFlush(parent);
        System.out.println("hello");
        return null;
    }

    @Override
    @RequestMapping(path = "/getuser/{userId}", method = RequestMethod.GET, produces = "application/json")
    public UserResponseDto getuser(@PathVariable int userId) throws BadRequestException {
        User user= new User();
        user = userRepository.findUserById(userId);
        if (user == null)
            throw new BadRequestException("User not found");
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setUserId(user.getId());


        return userResponseDto;
    }

    @RequestMapping(path="/user", method = RequestMethod.GET)
    public ResponseEntity  listUser(){
        return new ResponseEntity(parentRepository.findAll().toArray(), HttpStatus.OK);
    }

    @RequestMapping(path="/user/{id}", method = RequestMethod.GET)
    public ResponseEntity  listUser(@PathVariable(value = "id") String id){
        return new ResponseEntity(userRepository.findUserById(Integer.parseInt(id)), HttpStatus.OK);

    }

    @RequestMapping(path="/user", method = RequestMethod.POST)
    public ResponseEntity  listUser(@RequestBody User user){
        return new ResponseEntity("18", HttpStatus.OK);
    }



}
