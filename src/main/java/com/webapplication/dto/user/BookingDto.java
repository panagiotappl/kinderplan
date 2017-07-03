package com.webapplication.dto.user;

import java.sql.Timestamp;

/**
 * Created by mary on 3/7/2017.
 */
public class BookingDto {
	private Integer id;
	private Integer numOfTickets;
	private Integer total_price;
	private Timestamp booking_time;
	private Integer event_id;
	private Integer eventDate_id;
	private String event_name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumOfTickets() {
		return numOfTickets;
	}

	public void setNumOfTickets(Integer numOfTickets) {
		this.numOfTickets = numOfTickets;
	}

	public Integer getTotal_price() {
		return total_price;
	}

	public void setTotal_price(Integer total_price) {
		this.total_price = total_price;
	}

	public Timestamp getBooking_time() {
		return booking_time;
	}

	public void setBooking_time(Timestamp booking_time) {
		this.booking_time = booking_time;
	}

	public Integer getEvent_id() {
		return event_id;
	}

	public void setEvent_id(Integer event_id) {
		this.event_id = event_id;
	}

	public Integer getEventDate_id() {
		return eventDate_id;
	}

	public void setEventDate_id(Integer eventDate_id) {
		this.eventDate_id = eventDate_id;
	}

	public String getEvent_name() {
		return event_name;
	}

	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}
}
