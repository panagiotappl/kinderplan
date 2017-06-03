package com.webapplication.entity;

/**
 * Created by mary on 3/6/2017.
 */

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(
		name="Comments_Events"
)
public class CommentEventEntity {
	@Id
	@SequenceGenerator(name = "commentEvent_id_seq",
			sequenceName = "commentEvent_id_seq",
			allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
			generator = "commentEvent_id_seq")
	@Column(name = "id", nullable = false)
	private Integer id;
	private String comment;
	private Integer event;
	private Timestamp date;
	private Integer user_id;

	public CommentEventEntity() {
	}

	public CommentEventEntity(String comment, Integer event, Timestamp date, Integer user_id) {
		this.comment = comment;
		this.event = event;
		this.date = date;
		this.user_id = user_id;
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

	public Integer getEvent() {
		return event;
	}

	public void setEvent(Integer event) {
		this.event = event;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
}
