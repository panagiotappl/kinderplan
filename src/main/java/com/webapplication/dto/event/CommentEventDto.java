package com.webapplication.dto.event;

import com.webapplication.dto.user.ParentDto;

import java.sql.Timestamp;

/**
 * Created by mary on 4/6/2017.
 */
public class CommentEventDto {
	private String comment;
	private EventDto event;
	private Timestamp date;
	private ParentDto user_id;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public EventDto getEvent() {
		return event;
	}

	public void setEvent(EventDto event) {
		this.event = event;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public ParentDto getUser_id() {
		return user_id;
	}

	public void setUser_id(ParentDto user_id) {
		this.user_id = user_id;
	}
}
