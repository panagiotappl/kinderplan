package com.webapplication.dto.user;

import java.sql.Timestamp;

/**
 * Created by mary on 3/7/2017.
 */
public class ProfileCommentProviderDto {
	private String comment;
	private Timestamp date;
	private Integer parent_user_id;
	private String parent_name;
	private String parent_surname;

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

	public Integer getParent_user_id() {
		return parent_user_id;
	}

	public void setParent_user_id(Integer parent_user_id) {
		this.parent_user_id = parent_user_id;
	}

	public String getParent_name() {
		return parent_name;
	}

	public void setParent_name(String parent_name) {
		this.parent_name = parent_name;
	}

	public String getParent_surname() {
		return parent_surname;
	}

	public void setParent_surname(String parent_surname) {
		this.parent_surname = parent_surname;
	}
}
