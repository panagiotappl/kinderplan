package com.webapplication.exception.user;


import com.webapplication.error.user.UserError;

public class ForbiddenException extends Exception {

    public ForbiddenException(UserError error) {
        super(error.getDescription());
    }

}
