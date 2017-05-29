package com.webapplication.mapper;


import com.webapplication.dto.user.*;
import com.webapplication.entity.ParentEntity;
import com.webapplication.entity.ProviderEntity;
import com.webapplication.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponseDto userToUserResponse(UserEntity user) {
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

    public UserEntity userEntityFromUserDto(UserSignUpRequestDto userSignUpRequestDto){
        UserEntity userEntity= new UserEntity();
        userEntity.setName(userSignUpRequestDto.getName());
        userEntity.setSurname(userSignUpRequestDto.getSurname());
        userEntity.setEmail(userSignUpRequestDto.getEmail());
        userEntity.setCreatedDate(userSignUpRequestDto.getCreatedDate());
        userEntity.setPassword(userSignUpRequestDto.getPassword());
        userEntity.setRole(userSignUpRequestDto.getRole());
        return userEntity;
    }

    public ProviderEntity providerEntityFromProviderDto(ProviderRequestDto providerRequestDto){
        ProviderEntity providerEntity = new ProviderEntity();
        providerEntity.setCompanyName(providerRequestDto.getCompanyName());
        providerEntity.setVatNumber(providerRequestDto.getVatNumber());
        return providerEntity;
    }

    public ParentEntity parentEntityFromParentDto(ParentRequestDto parentRequestDto){
        ParentEntity parentEntity = new ParentEntity();
        parentEntity.setPoints(parentRequestDto.getPoints());
        return parentEntity;
    }



}
