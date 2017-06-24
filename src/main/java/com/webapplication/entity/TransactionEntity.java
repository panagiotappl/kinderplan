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

	public String getCard_number() {
		return card_number;
	}

	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getCardHolder() {
		return cardHolder;
	}

	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}

	public Timestamp getDate_expiration() {
		return date_expiration;
	}

	public void setDate_expiration(Timestamp date_expiration) {
		this.date_expiration = date_expiration;
	}

	private Integer ammount;
	private String card_number;
	private String cvv;
	private String cardHolder;
	private Timestamp date_expiration;
	private Timestamp date;
	@ManyToOne
	private EventEntity event;

	public TransactionEntity() {
	}

	public TransactionEntity( Integer ammount, Timestamp date, EventEntity event) {

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
