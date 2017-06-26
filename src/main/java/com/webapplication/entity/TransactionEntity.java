package com.webapplication.entity;

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

	public String getDate_expiration() {
		return date_expiration;
	}

	public void setDate_expiration(String date_expiration) {
		this.date_expiration = date_expiration;
	}

	private Integer amount;
	private String card_number;
	private String cvv;
	private String cardHolder;
	private String date_expiration;
	private Timestamp date;


	public TransactionEntity() {
	}

	public TransactionEntity( Integer amount, Timestamp date) {

		this.amount = amount;
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}


}
