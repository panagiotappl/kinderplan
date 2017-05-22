package com.webapplication.mappers;

import com.webapplication.dto.UserSignUpRequestDto;
import com.webapplication.entities.Providers;
import com.webapplication.entities.User;

import java.sql.Timestamp;

public class UserMapper {
    public  static User registerRequestToUser(UserSignUpRequestDto userDto) {
        User user = new User();
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
