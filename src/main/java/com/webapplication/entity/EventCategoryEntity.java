package com.webapplication.entity;

import javax.persistence.*;

/**
 * Created by mary on 3/6/2017.
 */


@Entity
@Table(
		name="event_category"
)
public class EventCategoryEntity {
	private Integer event_id;
	private Integer category_id;

	public EventCategoryEntity() {
	}

	public EventCategoryEntity(Integer event_id, Integer category_id) {
		this.event_id = event_id;
		this.category_id = category_id;
	}

	public Integer getEvent_id() {
		return event_id;
	}

	public void setEvent_id(Integer event_id) {
		this.event_id = event_id;
	}

	public Integer getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}
}
