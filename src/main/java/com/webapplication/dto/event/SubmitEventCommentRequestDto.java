package com.webapplication.dto.event;

/**
 * Created by mary on 2/7/2017.
 */
public class SubmitEventCommentRequestDto {
	private String comment;
	private Integer user_id;
	private Integer event_id;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getEvent_id() {
		return event_id;
	}

	public void setEvent_id(Integer event_id) {
		this.event_id = event_id;
	}
}
