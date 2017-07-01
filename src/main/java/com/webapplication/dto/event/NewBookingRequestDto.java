package com.webapplication.dto.event;

/**
 * Created by mary on 1/7/2017.
 */
public class NewBookingRequestDto {
	private Integer numOfTickets;
	private Integer parent_id;
	private Integer eventDate_id;

	public Integer getNumOfTickets() {
		return numOfTickets;
	}

	public void setNumOfTickets(Integer numOfTickets) {
		this.numOfTickets = numOfTickets;
	}

	public Integer getParent_id() {
		return parent_id;
	}

	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}

	public Integer getEventDate_id() {
		return eventDate_id;
	}

	public void setEventDate_id(Integer eventDate_id) {
		this.eventDate_id = eventDate_id;
	}
}
