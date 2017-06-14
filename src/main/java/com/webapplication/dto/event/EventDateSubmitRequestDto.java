package com.webapplication.dto.event;

import java.sql.Timestamp;

/**
 * Created by mary on 4/6/2017.
 */
public class EventDateSubmitRequestDto {
	private Timestamp start_date;
	private Timestamp end_date;
	private Integer available_tickets;
	private Integer tickets_sold;
	private String note;

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

	public Integer getTickets_sold() {
		return tickets_sold;
	}

	public void setTickets_sold(Integer tickets_sold) {
		this.tickets_sold = tickets_sold;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
