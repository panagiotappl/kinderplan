package com.webapplication.mapper;


import com.webapplication.dto.user.*;
import com.webapplication.entity.ParentEntity;
import com.webapplication.entity.ProviderEntity;
import com.webapplication.entity.TransactionEntity;
import com.webapplication.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class UserMapper {
    @Autowired
    private BookingMapper bookingMapper;
    @Autowired
    private EventMapper eventMapper;
    @Autowired
    private CommentProviderMapper commentProviderMapper;

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
            parentResponse.setParent_id(parent.getId());
            parentResponse.setPoints(parent.getPoints());
            parentResponse.setBookings(bookingMapper.bookingDtosFromBookingEntities(parent.getBookings()));
            userResponse.setParentDto(parentResponse);
        }else{
            providerResponse.setCompanyName(provider.getCompanyName());
            providerResponse.setVatNumber(provider.getVatNumber());
            userResponse.setProviderDto(providerResponse);
        }
        return userResponse;
    }


    public GuestProfileResponseDto userToGuestProfileResponse(UserEntity userEntity, ProviderEntity providerEntity){
        GuestProfileResponseDto userDto = new GuestProfileResponseDto();
        userDto.setId(userEntity.getId());
        userDto.setName(userEntity.getName());
        userDto.setSurname(userEntity.getSurname());
        userDto.setEmail(userEntity.getEmail());
        userDto.setProvider(guestProfileProviderDtoFromProviderEntity(providerEntity));

        return userDto;
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

    public GuestProfileProviderDto guestProfileProviderDtoFromProviderEntity(ProviderEntity providerEntity){
        if (providerEntity != null) {
            GuestProfileProviderDto providerDto = new GuestProfileProviderDto();
            providerDto.setProvider_id(providerEntity.getUser().getId());
            providerDto.setCompanyName(providerEntity.getCompanyName());
            providerDto.setEvents(eventMapper.eventProfileDtosFromEventEntities(providerEntity.getEvents()));
            providerDto.setComments(commentProviderMapper.profileCommentProviderDtosFromCommentProviderEntities(providerEntity.getComments()));

            return providerDto;
        }
        else {
            return null;
        }
    }

    public ParentEntity parentEntityFromParentDto(ParentDto parentDto){
        ParentEntity parentEntity = new ParentEntity();
        parentEntity.setPoints(parentDto.getPoints());
        return parentEntity;
    }


    public TransactionEntity transactionEntityFromTransactionDto(TransactionDto transactionDto, Integer amount, ParentEntity parent){
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setAmount(amount);
        transactionEntity.setCard_number(transactionDto.getCard_number());
        transactionEntity.setCardHolder(transactionDto.getCard_holder());
        transactionEntity.setCvv(transactionDto.getCvv());
        transactionEntity.setDate_expiration(transactionDto.getDate());
        System.out.println("mapper mapper");
        transactionEntity.setDate(new Timestamp(System.currentTimeMillis()));
        transactionEntity.setParent(parent);
        return transactionEntity;

    }

    public ParentCommentDto parentCommentDtoFromParentEntity(ParentEntity parentEntity){
        ParentCommentDto parentCommentDto = new ParentCommentDto();
        parentCommentDto.setId(parentEntity.getId());
        parentCommentDto.setUser_id(parentEntity.getUser().getId());
        parentCommentDto.setName(parentEntity.getUser().getName());
        parentCommentDto.setSurname(parentEntity.getUser().getSurname());
        return parentCommentDto;
    }

    public ProviderViewEventDto providerViewEventDtoFromProviderEntity(ProviderEntity providerEntity){
        ProviderViewEventDto providerDto = new ProviderViewEventDto();
        providerDto.setId(providerEntity.getId());
        providerDto.setVatNumber(providerEntity.getVatNumber());
        providerDto.setCompanyName(providerEntity.getCompanyName());
        providerDto.setUser_id(providerEntity.getUser().getId());
        providerDto.setEmail(providerEntity.getUser().getEmail());
        return providerDto;
    }
}
