package com.webapplication.exception;

import com.webapplication.error.event.EventError;
import com.webapplication.error.event.EventSubmitError;
import com.webapplication.error.user.UserError;
import com.webapplication.error.user.UserLogInError;
import com.webapplication.error.user.UserRegisterError;

public class ValidationException extends Exception {

    public ValidationException(UserRegisterError error) {
        super(error.getDescription());
    }

    public ValidationException(UserLogInError error) {
        super(error.getDescription());
    }

    public ValidationException(UserError error) {
        super(error.getDescription());
    }

    public ValidationException(EventError error){
        super(error.getDescription());
    }

    public ValidationException(EventSubmitError error){
        super(error.getDescription());
    }
}
