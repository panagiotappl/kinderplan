package com.webapplication.exceptions;

/**
 * Created by dimitris on 5/19/2017.
 */
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.naming.AuthenticationException;



@ResponseStatus(code= HttpStatus.BAD_REQUEST,  value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends AuthenticationException {


    public BadRequestException(String message) {
        super(message);

    }
}
