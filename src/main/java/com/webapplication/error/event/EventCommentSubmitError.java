package com.webapplication.error.event;

/**
 * Created by mary on 2/7/2017.
 */
public enum EventCommentSubmitError {
	MISSING_DATA("Required attributes are missing."),
	MISSING_COMMENT("Comment is missing."),
	MISSING_USER("User not specified."),
	MISSING_EVENT("Event not specified."),
	NOT_A_PARENT("The user is not a parent."),
	EVENT_NOT_EXISTS("This event does not exist.");

	private final String description;

	EventCommentSubmitError(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
