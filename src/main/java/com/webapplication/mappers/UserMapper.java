package com.webapplication.mappers;

import com.webapplication.dto.UserSignUpRequestDto;
import com.webapplication.entities.Users;

import java.sql.Timestamp;

public class UserMapper {
    public  static Users registerRequestToUser(UserSignUpRequestDto userDto) {
        Users user = new Users();
        user.setEmail(userDto.getEmail());
        user.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        user.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
        user.setLastLogin((new Timestamp(System.currentTimeMillis())));
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setPassword(userDto.getPassword());
        user.setValidated(true);
        return  user;
    }
}
