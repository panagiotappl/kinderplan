package com.webapplication.mapper;

import com.webapplication.dto.event.EventDateDto;
import com.webapplication.dto.event.EventDateSubmitRequestDto;
import com.webapplication.entity.EventDateEntity;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mary on 14/6/2017.
 */

@Component
public class EventDateMapper {
	public HashSet<EventDateEntity> eventDateEntitiyFromEventDateDto(HashSet<EventDateSubmitRequestDto> eventDatesDto){
		HashSet<EventDateEntity> eventDatesEntity = new HashSet<EventDateEntity>(eventDatesDto.size());
		for (EventDateSubmitRequestDto dateDto : eventDatesDto){
			EventDateEntity dateEntity = new EventDateEntity();
			dateEntity.setStart_date(dateDto.getStart_date());
			dateEntity.setEnd_date(dateDto.getEnd_date());
			dateEntity.setAvailable_tickets(dateDto.getAvailable_tickets());
			dateEntity.setTickets_sold(dateDto.getTickets_sold());
			dateEntity.setNote(dateDto.getNote());
			eventDatesEntity.add(dateEntity);
		}

		return eventDatesEntity;
	}

	public HashSet<EventDateDto> eventDateDtosFromEventDateEntities(Set<EventDateEntity> eventDateEntities){
		HashSet<EventDateDto> eventDateDtos = new HashSet<>(eventDateEntities.size());
		for (EventDateEntity eventDateEntity : eventDateEntities){
			EventDateDto eventDateDto = new EventDateDto();
			eventDateDto.setId(eventDateEntity.getId());
			eventDateDto.setStart_date(eventDateEntity.getStart_date());
			eventDateDto.setEnd_date(eventDateEntity.getEnd_date());
			eventDateDto.setAvailable_tickets(eventDateEntity.getAvailable_tickets());
			eventDateDto.setNote(eventDateEntity.getNote());
			eventDateDtos.add(eventDateDto);
		}

		return eventDateDtos;
	}
}
