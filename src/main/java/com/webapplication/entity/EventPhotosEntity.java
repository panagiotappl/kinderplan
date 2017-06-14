package com.webapplication.entity;

/**
 * Created by mary on 8/6/2017.
 */

import javax.persistence.*;

@Entity
@Table(
		name = "event_photos"
)
public class EventPhotosEntity {
	@Id
	@SequenceGenerator(name = "users_id_seq",
			sequenceName = "users_id_seq",
			allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY,
			generator = "users_id_seq")
	@Column(name = "id", nullable = false)
	private Integer id;
	private String photo_path;
	@ManyToOne
	private EventEntity event;

	public EventPhotosEntity() {
	}

	public EventPhotosEntity(String photo_path, EventEntity event) {
		this.photo_path = photo_path;
		this.event = event;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhoto_path() {
		return photo_path;
	}

	public void setPhoto_path(String photo_path) {
		this.photo_path = photo_path;
	}

	public EventEntity getEvent() {
		return event;
	}

	public void setEvent(EventEntity event) {
		this.event = event;
	}
}
