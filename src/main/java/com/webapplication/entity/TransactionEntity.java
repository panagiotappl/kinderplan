package com.webapplication.entity;

/**
 * Created by mary on 3/6/2017.
 */

import javax.persistence.*;
import javax.swing.tree.ExpandVetoException;
import java.sql.Timestamp;

@Entity
@Table(
		name = "transactions"
)
public class TransactionEntity {
	@Id
	@SequenceGenerator(name = "transactions_id_seq",
			sequenceName = "transactions_id_seq",
			allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY,
			generator = "transactions_id_seq")
	@Column(name = "id", nullable = false)
	private Integer id;
	@ManyToOne
	private ParentEntity user_id;
	private Integer ammount;
	private Timestamp date;
	@ManyToOne
	private EventEntity event;

	public TransactionEntity() {
	}

	public TransactionEntity(ParentEntity user_id, Integer ammount, Timestamp date, EventEntity event) {
		this.user_id = user_id;
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

	public ParentEntity getUser_id() {
		return user_id;
	}

	public void setUser_id(ParentEntity user_id) {
		this.user_id = user_id;
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

	public EventEntity getEvent() {
		return event;
	}

	public void setEvent(EventEntity event) {
		this.event = event;
	}
}
