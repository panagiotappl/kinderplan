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

	public EventEntity eventEntityFromEventDto(EventSubmitRequestDto eventSubmitRequestDto){
		EventEntity eventEntity= new EventEntity();
		eventEntity.setName(eventSubmitRequestDto.getName());
		//eventEntity.setProvider(eventSubmitRequestDto.getProvider());
		eventEntity.setAddress(eventSubmitRequestDto.getAddress());
		eventEntity.setLongitude(eventSubmitRequestDto.getLongitude());
		eventEntity.setLatitude(eventSubmitRequestDto.getLatitude());
		eventEntity.setAge_from(eventSubmitRequestDto.getAge_from());
		eventEntity.setAge_to(eventSubmitRequestDto.getAge_to());
		eventEntity.setTicket_price(eventSubmitRequestDto.getTicket_price());
		eventEntity.setDescription(eventSubmitRequestDto.getDescription());
		eventEntity.setDate_ending(eventSubmitRequestDto.getDate_ending());
		eventEntity.setDate_starting(eventSubmitRequestDto.getDate_starting());
		//eventEntity.setCategories(eventSubmitRequestDto.getCategories());
		eventEntity.setComments(null);
		//eventEntity.setDates(eventSubmitRequestDto.getDates());
		eventEntity.setTransactions(null);
		//eventEntity.setPhotos(eventSubmitRequestDto.getPhotos());
		return eventEntity;
	}
}
