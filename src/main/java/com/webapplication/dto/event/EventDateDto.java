package com.webapplication.dto.event;

import java.sql.Timestamp;

/**
 * Created by mary on 2/7/2017.
 */

public class EventDateDto {
	private Integer id;
	private Timestamp start_date;
	private Timestamp end_date;
	private Integer available_tickets;
	private String note;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getStart_date() {
		return start_date;
	}

	public void setStart_date(Timestamp start_date) {
		this.start_date = start_date;
	}

	public Timestamp getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Timestamp end_date) {
		this.end_date = end_date;
	}

	public Integer getAvailable_tickets() {
		return available_tickets;
	}

	public void setAvailable_tickets(Integer available_tickets) {
		this.available_tickets = available_tickets;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
