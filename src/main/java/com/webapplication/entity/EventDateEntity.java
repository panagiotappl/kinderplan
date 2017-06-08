package com.webapplication.entity;

/**
 * Created by mary on 3/6/2017.
 */

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(
		name="event_dates"
)
public class EventDateEntity {
	@Id
	@SequenceGenerator(name = "eventDates_id_seq",
			sequenceName = "eventDates_id_seq",
			allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY,
			generator = "eventDates_id_seq")
	@Column(name = "id", nullable = false)
	private Integer id;
	@ManyToOne
	private EventEntity event;
	private Timestamp start_date;
	private Timestamp end_date;
	private Integer available_tickets;
	private Integer tickets_sold;
	private String note;

	public EventDateEntity() {
	}

	public EventDateEntity(Integer id, EventEntity event, Timestamp start_date, Timestamp end_date, Integer available_tickets) {
		this.id = id;
		this.event = event;
		this.start_date = start_date;
		this.end_date = end_date;
		this.available_tickets = available_tickets;
	}

	public EventDateEntity(Integer id, EventEntity event, Timestamp start_date, Timestamp end_date, Integer available_tickets, String note) {
		this.id = id;
		this.event = event;
		this.start_date = start_date;
		this.end_date = end_date;
		this.available_tickets = available_tickets;
		this.note = note;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EventEntity getEvent() {
		return event;
	}

	public void setEvent(EventEntity event) {
		this.event = event;
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
