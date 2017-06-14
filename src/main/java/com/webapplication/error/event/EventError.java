package com.webapplication.error.event;

/**
 * Created by mary on 11/6/2017.
 */
public enum EventError {
	EVENT_DOES_NOT_EXIST("Event does not exist."),
	INVALID_DATA("Invalid data."),
	MISSING_DATA("Missing data.");


	private final String description;

	EventError(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
