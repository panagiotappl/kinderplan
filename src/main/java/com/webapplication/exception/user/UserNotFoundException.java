package com.webapplication.exception.user;

import com.webapplication.error.user.UserError;
import com.webapplication.error.user.UserLogInError;
import com.webapplication.error.user.UserRegisterError;

public class UserNotFoundException extends Exception {

	public UserNotFoundException(UserRegisterError error) {
		super(error.getDescription());
	}

	public UserNotFoundException(UserLogInError error) {
		super(error.getDescription());
	}

	public UserNotFoundException(UserError error) {
		super(error.getDescription());
	}

}
