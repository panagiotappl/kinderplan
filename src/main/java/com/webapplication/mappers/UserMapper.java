package com.webapplication.mappers;

import com.webapplication.dto.UserDto;
import com.webapplication.dto.UserLogInResponseDto;
import com.webapplication.dto.UserSignUpRequestDto;
import com.webapplication.entities.Users;

import java.sql.Timestamp;

public class UserMapper {
    public static Users registerRequestToUser(UserSignUpRequestDto userDto) {
        Users user = new Users();
        user.setEmail(userDto.getEmail());
        user.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        user.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
        user.setLastLogin((new Timestamp(System.currentTimeMillis())));
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setPassword(userDto.getPassword());
        user.setValidated(true);
        return user;
    }

    public static UserDto fromUserToResponseDto(Users user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setRole(user.getRole());
        userDto.setCreatedDate(user.getCreatedDate());
        userDto.setEmail(user.getEmail());
        userDto.setLastLogin(user.getLastLogin());
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());
        userDto.setEmail(user.getEmail());
        userDto.setUpdatedDate(user.getUpdatedDate());
        userDto.setValidated(user.getValidated());
        return userDto;
    }

    public static UserLogInResponseDto fromUserToLogInResponseDto(Users user){
        UserLogInResponseDto userLogInResponseDto = new UserLogInResponseDto();
        userLogInResponseDto.setEmail(user.getEmail());
        userLogInResponseDto.setId(user.getId());
        return userLogInResponseDto;
    }
}
