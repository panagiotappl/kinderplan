package com.webapplication.dto.user;

/**
 * Created by mary on 2/7/2017.
 */
public class SubmitProviderCommentRequestDto {
	private String comment;
	private Integer user_id;
	private Integer provider_id;

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

	public Integer getProvider_id() {
		return provider_id;
	}

	public void setProvider_id(Integer provider_id) {
		this.provider_id = provider_id;
	}
}
