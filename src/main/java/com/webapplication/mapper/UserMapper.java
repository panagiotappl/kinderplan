package com.webapplication.mapper;


import com.webapplication.dto.user.UserResponseDto;
import com.webapplication.entity.Users;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponseDto userToUserResponse(Users user) {
        if (user == null)
            return null;

        UserResponseDto userResponse = new UserResponseDto();
        userResponse.setId(user.getId());
        userResponse.setEmail(user.getEmail());
        userResponse.setName(user.getName());
        userResponse.setSurname(user.getSurname());
        userResponse.setCreatedDate(user.getCreatedDate());
        userResponse.setValidated(user.getValidated());

        return userResponse;
    }
//    public static Users registerRequestToUsers(UsersSignUpRequestDto UsersDto) {
//        Users user = new Users();
//        user Users.setEmail(UsersDto.getEmail());
//        user.setCreatedDate(new Timestamp(System.currentTimeMillis()));
//        user.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
//        user.setLastLogin((new Timestamp(System.currentTimeMillis())));
//        user.setName(UsersDto.getName());
//        user.setSurname(UsersDto.getSurname());
//        user.setPassword(UsersDto.getPassword());
//        user.setValidated(true);
//        return user;
//    }
//
//    public static UsersDto fromUsersToResponseDto(Users Users) {
//        UsersDto UsersDto = new UsersDto();
//        UsersDto.setId(Users.getId());
//        UsersDto.setRole(Users.getRole());
//        UsersDto.setCreatedDate(Users.getCreatedDate());
//        UsersDto.setEmail(Users.getEmail());
//        UsersDto.setLastLogin(Users.getLastLogin());
//        UsersDto.setName(Users.getName());
//        UsersDto.setSurname(Users.getSurname());
//        UsersDto.setEmail(Users.getEmail());
//        UsersDto.setUpdatedDate(Users.getUpdatedDate());
//        UsersDto.setValidated(Users.getValidated());
//        return UsersDto;
//    }


}
