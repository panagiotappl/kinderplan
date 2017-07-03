package com.webapplication.dto.user;

import com.webapplication.dto.event.EventProfileDto;

import java.util.HashSet;

/**
 * Created by mary on 3/7/2017.
 */
public class GuestProfileProviderDto {
	private Integer provider_id;
	private String companyName;
	private HashSet<EventProfileDto> events;
	private HashSet<ProfileCommentProviderDto> comments;

	public Integer getProvider_id() {
		return provider_id;
	}

	public void setProvider_id(Integer provider_id) {
		this.provider_id = provider_id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public HashSet<EventProfileDto> getEvents() {
		return events;
	}

	public void setEvents(HashSet<EventProfileDto> events) {
		this.events = events;
	}

	public HashSet<ProfileCommentProviderDto> getComments() {
		return comments;
	}

	public void setComments(HashSet<ProfileCommentProviderDto> comments) {
		this.comments = comments;
	}
}
