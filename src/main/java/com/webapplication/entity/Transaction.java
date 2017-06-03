package com.webapplication.entity;

/**
 * Created by mary on 3/6/2017.
 */

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(
		name="Transactions"
)
public class Transaction {
	@Id
	@SequenceGenerator(name = "transaction_id_seq",
			sequenceName = "transaction_id_seq",
			allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
			generator = "transaction_id_seq")
	@Column(name = "id", nullable = false)
	private Integer id;
	private Integer user;
	private Integer ammount;
	private Timestamp date;
	private Integer event;

	public Transaction() {
	}

	public Transaction(Integer user, Integer ammount, Timestamp date, Integer event) {
		this.user = user;
		this.ammount = ammount;
		this.date = date;
		this.event = event;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUser() {
		return user;
	}

	public void setUser(Integer user) {
		this.user = user;
	}

	public Integer getAmmount() {
		return ammount;
	}

	public void setAmmount(Integer ammount) {
		this.ammount = ammount;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public Integer getEvent() {
		return event;
	}

	public void setEvent(Integer event) {
		this.event = event;
	}
}
