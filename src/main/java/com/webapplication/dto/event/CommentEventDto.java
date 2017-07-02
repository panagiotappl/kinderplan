package com.webapplication.dto.event;

import com.webapplication.dto.user.ParentCommentDto;
import com.webapplication.dto.user.ParentDto;

import java.sql.Timestamp;

/**
 * Created by mary on 4/6/2017.
 */
public class CommentEventDto {
	private String comment;
	private Timestamp date;
	private ParentCommentDto parent;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public ParentCommentDto getParent() {
		return parent;
	}

	public void setParent(ParentCommentDto parent) {
		this.parent = parent;
	}
}
