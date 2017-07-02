package com.webapplication.entity;

/**
 * Created by mary on 3/6/2017.
 */

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(
		name="event_comments"
)
public class CommentEventEntity {
	@Id
	@SequenceGenerator(name = "commentEvent_id_seq",
			sequenceName = "commentEvent_id_seq",
			allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY,
			generator = "commentEvent_id_seq")
	@Column(name = "id", nullable = false)
	private Integer id;
	private String comment;
	@ManyToOne
	private EventEntity event;
	private Timestamp date;
	@ManyToOne
	private ParentEntity parent;

	public CommentEventEntity() {
	}

	public CommentEventEntity(String comment, EventEntity event, Timestamp date, ParentEntity user_id) {
		this.comment = comment;
		this.event = event;
		this.date = date;
		this.parent = user_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public EventEntity getEvent() {
		return event;
	}

	public void setEvent(EventEntity event) {
		this.event = event;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public ParentEntity getParent() {
		return parent;
	}

	public void setParent(ParentEntity parent) {
		this.parent = parent;
	}
}
