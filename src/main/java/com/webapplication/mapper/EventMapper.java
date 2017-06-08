package com.webapplication.mapper;

import com.webapplication.dto.event.*;
import com.webapplication.entity.EventEntity;
import org.springframework.stereotype.Component;

/**
 * Created by mary on 5/6/2017.
 */

@Component
public class EventMapper {
	public EventResponseDto eventToEventResponse(EventEntity event){
		if (event == null)
			return null;

		EventResponseDto eventResponse = new EventResponseDto();
		eventResponse.setId(event.getId());
		eventResponse.setName(event.getName());
		eventResponse.setAddress(event.getAddress());
		eventResponse.setLongitude(event.getLongitude());
		eventResponse.setLatitude(event.getLatitude());
		eventResponse.setAge_from(event.getAge_from());
		eventResponse.setAge_to(event.getAge_to());
		eventResponse.setTicket_price(event.getTicket_price());
		eventResponse.setDescription(event.getDescription());
		eventResponse.setDate_starting(event.getDate_starting());
		eventResponse.setDate_ending(event.getDate_ending());

		return eventResponse;
	}
}