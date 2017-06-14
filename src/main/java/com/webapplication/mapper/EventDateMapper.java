package com.webapplication.mapper;

import com.webapplication.dto.event.EventDateSubmitRequestDto;
import com.webapplication.entity.EventDateEntity;
import org.springframework.stereotype.Component;

import java.util.HashSet;

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
}
