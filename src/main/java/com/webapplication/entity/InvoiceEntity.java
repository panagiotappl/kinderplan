package com.webapplication.entity;

/**
 * Created by mary on 3/6/2017.
 */

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(
		name="invoices"
)
public class InvoiceEntity {
	@Id
	@SequenceGenerator(name = "invoice_id_seq",
			sequenceName = "invoice_id_seq",
			allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY,
			generator = "invoice_id_seq")
	@Column(name = "id", nullable = false)
	private Integer id;
	private Float amount;
	@ManyToOne
	private ProviderEntity provider;
	private Timestamp date_issued;
	private Timestamp date_send;

	public InvoiceEntity() {
	}

	public InvoiceEntity(Float amount, ProviderEntity provider, Timestamp date_issued, Timestamp date_send) {
		this.amount = amount;
		this.provider = provider;
		this.date_issued = date_issued;
		this.date_send = date_send;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public ProviderEntity getProvider() {
		return provider;
	}

	public void setProvider(ProviderEntity provider) {
		this.provider = provider;
	}

	public Timestamp getDate_issued() {
		return date_issued;
	}

	public void setDate_issued(Timestamp date_issued) {
		this.date_issued = date_issued;
	}

	public Timestamp getDate_send() {
		return date_send;
	}

	public void setDate_send(Timestamp date_send) {
		this.date_send = date_send;
	}
}
