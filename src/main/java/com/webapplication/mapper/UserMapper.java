package com.webapplication.mapper;


import com.webapplication.dto.user.*;
import com.webapplication.entity.ParentEntity;
import com.webapplication.entity.ProviderEntity;
import com.webapplication.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponseDto userToUserResponse(UserEntity user, ParentEntity parent, ProviderEntity provider) {
        if (user == null)
            return null;

        UserResponseDto userResponse = new UserResponseDto();
        userResponse.setId(user.getId());
        userResponse.setEmail(user.getEmail());
        userResponse.setName(user.getName());
        userResponse.setSurname(user.getSurname());
        userResponse.setCreatedDate(user.getCreatedDate());
        userResponse.setValidated(user.getValidated());


        ParentDto parentResponse = new ParentDto();
        ProviderDto providerResponse = new ProviderDto();

        if(user.getRole().equals("parent")) {
            parentResponse.setPoints(parent.getPoints());
            userResponse.setParentDto(parentResponse);
        }else{
            providerResponse.setCompanyName(provider.getCompanyName());
            providerResponse.setVatNumber(provider.getVatNumber());
            userResponse.setProviderDto(providerResponse);
        }
        return userResponse;
    }

    public UserEntity userEntityFromUserDto(UserSignUpRequestDto userSignUpRequestDto, String encodedPassword, String encodedSaltAsString){
        UserEntity userEntity= new UserEntity();
        userEntity.setName(userSignUpRequestDto.getName());
        userEntity.setSurname(userSignUpRequestDto.getSurname());
        userEntity.setEmail(userSignUpRequestDto.getEmail());
        userEntity.setCreatedDate(userSignUpRequestDto.getCreatedDate());
        userEntity.setPassword(encodedPassword);
        userEntity.setSalt(encodedSaltAsString);
        userEntity.setRole(userSignUpRequestDto.getRole());
        return userEntity;
    }

    public ProviderEntity providerEntityFromProviderDto(ProviderDto providerDto){
        ProviderEntity providerEntity = new ProviderEntity();
        providerEntity.setCompanyName(providerDto.getCompanyName());
        providerEntity.setVatNumber(providerDto.getVatNumber());
        return providerEntity;
    }

    public ParentEntity parentEntityFromParentDto(ParentDto parentDto){
        ParentEntity parentEntity = new ParentEntity();
        parentEntity.setPoints(parentDto.getPoints());
        return parentEntity;
    }



}
