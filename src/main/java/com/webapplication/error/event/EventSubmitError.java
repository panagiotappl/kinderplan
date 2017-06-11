package com.webapplication.error.event;

/**
 * Created by mary on 11/6/2017.
 */
public enum EventSubmitError {
	MISSING_DATA("Required attributes are missing."),
	MISSING_NAME("Name is missing."),
	MISSING_ADDRESS("Address is missing."),
	MISSING_AGE_FROM("Minimum Age restriction is missing"),
	MISSING_AGE_TO("Maximum Age restriction is missing."),
	MISSING_TICKETPRICE("Ticket Price is missing."),
	MISSING_DESCRIPTION("Description is missing."),
	MISSING_DATE_STARTING("Starting Date is missing."),
	MISSING_DATE_ENDING("Ending Date is missing."),
	MISSING_CATEGORY("Category is missing."),
	MISSING_DATES("Event Dates are not specified"),
	INVALID_DATA("Invalid data."),
	EXISTING_EVENT("There already exists an event with these details.");

	private final String description;

	EventSubmitError(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
