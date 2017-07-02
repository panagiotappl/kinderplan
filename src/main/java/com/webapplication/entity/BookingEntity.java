package com.webapplication.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by mary on 1/7/2017.
 */

@Entity
@Table(
	name = "bookings"
)
public class BookingEntity {
	@Id
	@SequenceGenerator(name = "parents_id_seq",
			sequenceName = "parents_id_seq",
			allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY,
			generator = "parents_id_seq")
	@Column(name = "id", nullable = false)
	private Integer id;
	private Integer numOfTickets;
	private Integer total_price;
	private Timestamp booking_time;
	@ManyToOne
	private ParentEntity parent;
	@ManyToOne
	private EventDateEntity eventDate;

	public BookingEntity() {
	}

	public BookingEntity(Integer numOfTickets, ParentEntity parent, EventDateEntity eventDate) {
		this.numOfTickets = numOfTickets;
		this.parent = parent;
		this.eventDate = eventDate;
	}

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

	public ParentEntity getParent() {
		return parent;
	}

	public void setParent(ParentEntity parent) {
		this.parent = parent;
	}

	public EventDateEntity getEventDate() {
		return eventDate;
	}

	public void setEventDate(EventDateEntity eventDate) {
		this.eventDate = eventDate;
	}
}
