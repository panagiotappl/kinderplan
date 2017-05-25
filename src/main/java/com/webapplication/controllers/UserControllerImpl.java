package com.webapplication.controllers;

import com.webapplication.dao.ParentRepository;
import com.webapplication.dao.ProviderRepository;
import com.webapplication.dao.UsersRepository;
import com.webapplication.dto.UserLogInResponseDto;
import com.webapplication.entities.Users;
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

//    @Override
//    @RequestMapping(path = "/login", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
//    public UserLogInResponseDto login(@RequestBody UserLoginRequestDto userLogInRequestDto) throws BadRequestException {
//        User user= new User();
//        user=userRepository.findUserByEmailAndPassword(userLogInRequestDto.getEmail(),userLogInRequestDto.getPassword());
//        if (user == null)
//            throw new BadRequestException("User not found");
//        //prepare response
//        UUID generatedToken = UUID.randomUUID();
//        UserLogInResponseDto userLogInResponseDto = new UserLogInResponseDto();
//        userLogInResponseDto.setUserId((long) user.getId());
//        userLogInResponseDto.setRole(user.getRole());
//        userLogInResponseDto.setGeneratedToken(generatedToken);
//        return userLogInResponseDto;
//    }
//
//    @Override
//    @RequestMapping(path = "/providersignup", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
//    public UserSignUpResponseDto providerSignUp(@RequestBody UserSignUpRequestDto userSignUpRequestDto){
//        //todo check user's data
//        User user =UserMapper.registerRequestToUser(userSignUpRequestDto);
//        user.setRole("Provider");
//        Providers provider = new Providers();
//        provider.setVatNumber(0);
//        provider.setCompanyName(userSignUpRequestDto.getCompanyName());
//        provider.setUsersEntityByUserId(user);
//        providerRepository.saveAndFlush(provider);
//        System.out.println("hello");
//        return null;
//    }
//
//    @Override
//    @RequestMapping(path = "/parentsignup", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
//    public UserSignUpResponseDto parentSignUp(@RequestBody UserSignUpRequestDto userSignUpRequestDto){
//        //todo check user's data
//        User user =UserMapper.registerRequestToUser(userSignUpRequestDto);
//        user.setRole("Parent");//todo create enum for roles
//        Parents parent = new Parents();
//        parent.setPoints(0);
//        parent.setUsersEntityByUserId(user);
//        parentRepository.saveAndFlush(parent);
//        System.out.println("hello");
//        return null;
//    }
//
//    @Override
//    @RequestMapping(path = "/getuser/{userId}", method = RequestMethod.GET, produces = "application/json")
//    public UserResponseDto getuser(@PathVariable int userId) throws BadRequestException {
//        User user= new User();
//        user = userRepository.findUserById(userId);
//        if (user == null)
//            throw new BadRequestException("User not found");
//        UserResponseDto userResponseDto = new UserResponseDto();
//        userResponseDto.setEmail(user.getEmail());
//        userResponseDto.setUserId(user.getId());
//
//
//        return userResponseDto;
//    }

    @RequestMapping(path="/user", method = RequestMethod.GET,consumes = "application/json",produces = "application/json")
    public ResponseEntity  listUser(){
        return new ResponseEntity(usersRepository.findAll().toArray(), HttpStatus.OK);
    }

    @RequestMapping(path="/userById", method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    public ResponseEntity  listUser(@RequestBody String userId){
        return new ResponseEntity(usersRepository.findUserById(1), HttpStatus.OK);

    }

    @RequestMapping(path="/user", method = RequestMethod.POST)
    public ResponseEntity  listUser(@RequestBody Users user){
        return new ResponseEntity(usersRepository.findAll().toArray(), HttpStatus.OK);

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public UserLogInResponseDto currentUserName(Principal principal) {
        Users user = new Users();
        user = usersRepository.findUsersByEmail(principal.getName());
        UserLogInResponseDto userLogInResponseDto = new UserLogInResponseDto();
        userLogInResponseDto.setEmail(user.getEmail());
        userLogInResponseDto.setId(user.getId());
        userLogInResponseDto.setName(user.getName());
        userLogInResponseDto.setSurname(user.getSurname());

        return userLogInResponseDto;
    }



}
