package com.webapplication.entity;

/**
 * Created by mary on 3/6/2017.
 */

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(
        name = "events"
)
public class EventEntity {

    @Id
    @SequenceGenerator(name = "events_id_seq",
            sequenceName = "events_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY,
            generator = "events_id_seq")
    @Column(name = "id", nullable = false)
    private Integer id;
    private String name;
    @ManyToOne
    private ProviderEntity provider;
    private String address;
    private Float longitude;
    private Float latitude;
    private Integer age_from;
    private Integer age_to;
    private Integer ticket_price;
    private String description;
    private Timestamp dateCreated;
    private Timestamp dateEnding;
    private Timestamp dateStarting;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="events_categories", joinColumns={@JoinColumn(referencedColumnName="id")}, inverseJoinColumns={@JoinColumn(referencedColumnName="id")})
	private Set<CategoryEntity> categories = new HashSet<CategoryEntity>(0);
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "event_id")
	private Set<CommentEventEntity> comments = new HashSet<CommentEventEntity>(0);
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "event_id")
	private Set<EventDateEntity> dates = new HashSet<EventDateEntity>(0);
	@OneToMany
	@JoinColumn(name = "event_id")
	private Set<TransactionEntity> transactions = new HashSet<TransactionEntity>(0);
	@OneToMany
	@JoinColumn(name = "event_id")
	private Set<EventPhotosEntity> photos = new HashSet<EventPhotosEntity>(0);

    public EventEntity(){
    }

	public EventEntity(String name, ProviderEntity provider, String address, Float longitude, Float latitude, Integer age_from, Integer age_to, Integer ticket_price,
					   String description, Timestamp date_created, Timestamp date_ending, Timestamp date_starting) {
		this.name = name;
		this.provider = provider;
		this.address = address;
		this.longitude = longitude;
		this.latitude = latitude;
		this.age_from = age_from;
		this.age_to = age_to;
		this.ticket_price = ticket_price;
		this.description = description;
		this.dateCreated = date_created;
		this.dateEnding = date_ending;
		this.dateStarting = date_starting;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProviderEntity getProvider() {
		return provider;
	}

	public void setProvider(ProviderEntity provider) {
		this.provider = provider;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Integer getAge_from() {
		return age_from;
	}

	public void setAge_from(Integer age_from) {
		this.age_from = age_from;
	}

	public Integer getAge_to() {
		return age_to;
	}

	public void setAge_to(Integer age_to) {
		this.age_to = age_to;
	}

	public Integer getTicket_price() {
		return ticket_price;
	}

	public void setTicket_price(Integer ticket_price) {
		this.ticket_price = ticket_price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getDate_created() {
		return dateCreated;
	}

	public void setDate_created(Timestamp date_created) {
		this.dateCreated = date_created;
	}

	public Timestamp getDate_ending() {
		return dateEnding;
	}

	public void setDate_ending(Timestamp date_ending) {
		this.dateEnding = date_ending;
	}

	public Timestamp getDate_starting() {
		return dateStarting;
	}

	public void setDate_starting(Timestamp date_starting) {
		this.dateStarting = date_starting;
	}

	public Set<CategoryEntity> getCategories() {
		return categories;
	}

	public void setCategories(Set<CategoryEntity> categories) {
		this.categories = categories;
	}

	public Set<CommentEventEntity> getComments() {
		return comments;
	}

	public void setComments(Set<CommentEventEntity> comments) {
		this.comments = comments;
	}

	public Set<EventDateEntity> getDates() {
		return dates;
	}

	public void setDates(Set<EventDateEntity> dates) {
		this.dates = dates;
	}

	public Set<TransactionEntity> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<TransactionEntity> transactions) {
		this.transactions = transactions;
	}

	public Set<EventPhotosEntity> getPhotos() {
		return photos;
	}

	public void setPhotos(Set<EventPhotosEntity> photos) {
		this.photos = photos;
	}
}
