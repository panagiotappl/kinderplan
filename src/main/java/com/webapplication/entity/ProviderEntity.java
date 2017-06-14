package com.webapplication.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dimitris on 5/21/2017.
 */
@Entity
@Table(
		name = "providers"
)
public class ProviderEntity {
    @Id
    @SequenceGenerator(name = "providers_id_seq",
            sequenceName = "providers_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY,
            generator = "providers_id_seq")
    @Column(name = "id", nullable = false)
    private Integer id;
    private Integer vatNumber;
    private String companyName;
    @OneToOne
    private UserEntity user;
    @OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "provider_id")
    private Set<EventEntity> events = new HashSet<EventEntity>(0);
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "provider_id")
	private Set<CommentProviderEntity> comments = new HashSet<CommentProviderEntity>(0);
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "provider_id")
	private Set<InvoiceEntity> invoices = new HashSet<InvoiceEntity>(0);

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(Integer vatNumber) {
        this.vatNumber = vatNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Set<EventEntity> getEvents() {
        return events;
    }

    public void setEvents(Set<EventEntity> events) {
        this.events = events;
    }

	public Set<CommentProviderEntity> getComments() {
		return comments;
	}

	public void setComments(Set<CommentProviderEntity> comments) {
		this.comments = comments;
	}

	public Set<InvoiceEntity> getInvoices() {
		return invoices;
	}

	public void setInvoices(Set<InvoiceEntity> invoices) {
		this.invoices = invoices;
	}
}
