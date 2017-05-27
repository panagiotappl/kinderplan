package com.webapplication.exception;

import com.webapplication.error.user.UserError;

public class NotAuthorizedException extends Exception {

	public NotAuthorizedException(UserError error) {
		super(error.getDescription());
	}

}
