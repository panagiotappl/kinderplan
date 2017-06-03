package com.webapplication.entity;

/**
 * Created by mary on 3/6/2017.
 */

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(
		name="Comments_Provider"
)
public class CommentProviderEntity {
	@Id
	@SequenceGenerator(name = "commentProvider_id_seq",
			sequenceName = "commentProvider_id_seq",
			allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
			generator = "commentProvider_id_seq")
	@Column(name = "id", nullable = false)
	private Integer id;
	private String comment;
	private Integer provider;
	private Timestamp date;
	private Integer user_id;

	public CommentProviderEntity() {
	}

	public CommentProviderEntity(String comment, Integer event, Timestamp date, Integer user_id) {
		this.comment = comment;
		this.provider = event;
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
		return provider;
	}

	public void setEvent(Integer event) {
		this.provider = event;
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
