package com.webapplication.dto.user;

import org.springframework.http.HttpStatus;

/**
 * Created by dimitris on 5/29/2017.
 */
public class SuccessResponseDto {
    private HttpStatus status;
    private String message;
    SuccessResponseDto(String message){
        this.message=message;
        this.status=HttpStatus.OK;
    }
}
