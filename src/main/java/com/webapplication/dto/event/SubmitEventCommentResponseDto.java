package com.webapplication.dto.event;

import org.springframework.http.HttpStatus;

/**
 * Created by mary on 2/7/2017.
 */

public class SubmitEventCommentResponseDto {
	private HttpStatus status;
	private String message;

	public SubmitEventCommentResponseDto(HttpStatus status, String message) {
		this.status = status;
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
