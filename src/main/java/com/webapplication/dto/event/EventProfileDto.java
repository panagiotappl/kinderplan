package com.webapplication.dto.event;

import com.webapplication.dto.CategoryDto;

import java.sql.Timestamp;
import java.util.HashSet;

/**
 * Created by mary on 3/7/2017.
 */
public class EventProfileDto {
	private Integer id;
	private String name;
	private String description;
	private EventPhotosDto photo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public EventPhotosDto getPhoto() {
		return photo;
	}

	public void setPhoto(EventPhotosDto photo) {
		this.photo = photo;
	}
}
