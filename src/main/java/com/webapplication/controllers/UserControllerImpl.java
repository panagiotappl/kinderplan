package com.webapplication.controllers;

import com.webapplication.dao.UserRepository;
import com.webapplication.dto.UserLogInResponseDto;
import com.webapplication.dto.UserLoginRequestDto;
import com.webapplication.dto.UserSignUpRequestDto;
import com.webapplication.dto.UserSignUpResponseDto;
import com.webapplication.entities.UsersEntity;
import com.webapplication.exceptions.BadRequestException;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;
import java.util.UUID;

@Component
public class UserControllerImpl implements UserController {
    @Autowired
    private UserRepository userRepository;

    @Override
    @RequestMapping(path = "/login", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public UserLogInResponseDto login(@RequestBody UserLoginRequestDto userLogInRequestDto) throws BadRequestException {
        UsersEntity user= new UsersEntity();
        user=userRepository.findUserByEmailAndPassword(userLogInRequestDto.getEmail(),userLogInRequestDto.getPassword());
        if (user == null)
            throw new BadRequestException("User not found");
        //prepare response
        UUID generatedToken = UUID.randomUUID();
        UserLogInResponseDto userLogInResponseDto = new UserLogInResponseDto();
        userLogInResponseDto.setUserId((long) user.getId());
        userLogInResponseDto.setRole((String) user.getCategory().toString());
        userLogInResponseDto.setGeneratedToken(generatedToken);
        return userLogInResponseDto;
    }

    @Override
    @RequestMapping(path = "/signup", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public UserSignUpResponseDto signup(@RequestBody UserSignUpRequestDto userSignUpRequestDto){
        //todo check user's data


        return null;
    }

}
