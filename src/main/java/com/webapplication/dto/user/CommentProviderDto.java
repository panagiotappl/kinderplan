package com.webapplication.dto.user;

import java.sql.Timestamp;

/**
 * Created by mary on 4/6/2017.
 */
public class CommentProviderDto {
	private String comment;
	private ProviderDto provider;
	private Timestamp date;
	private ParentDto user_id;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public ProviderDto getProvider() {
		return provider;
	}

	public void setProvider(ProviderDto provider) {
		this.provider = provider;
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
