package com.webapplication.error.event;

/**
 * Created by mary on 1/7/2017.
 */
public enum NewBookingSubmitError {
	MISSING_DATA("Required attributes are missing."),
	MISSING_TICKETS("Tickets to be booked are missing."),
	MISSING_PARENT("Parent is missing."),
	MISSING_EVENT("Event is missing"),
	INVALID_DATA("Invalid data."),
	NOT_A_PARENT("The user is not a parent."),
	NOT_ENOUGH_TICKETS("The event does not have enough tickets left this day."),
	NOT_ENOUGH_POINTS("Insufficient points.");

	private final String description;

	NewBookingSubmitError(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
