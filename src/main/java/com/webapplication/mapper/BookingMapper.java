package com.webapplication.mapper;

import com.webapplication.dto.event.NewBookingRequestDto;
import com.webapplication.entity.BookingEntity;
import com.webapplication.entity.EventDateEntity;
import com.webapplication.entity.ParentEntity;
import org.springframework.stereotype.Component;

/**
 * Created by mary on 1/7/2017.
 */

@Component
public class BookingMapper {
	public BookingEntity bookingEntityFromBookingRequestDto(NewBookingRequestDto newBookingRequestDto, ParentEntity parentEntity, EventDateEntity eventDateEntity){
		BookingEntity bookingEntity = new BookingEntity();

		bookingEntity.setNumOfTickets(newBookingRequestDto.getNumOfTickets());
		bookingEntity.setEventDate(eventDateEntity);
		bookingEntity.setParent(parentEntity);

		return bookingEntity;
	}
}
