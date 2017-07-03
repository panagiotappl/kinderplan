package com.webapplication.mapper;

import com.webapplication.dto.event.NewBookingRequestDto;
import com.webapplication.dto.user.BookingDto;
import com.webapplication.entity.BookingEntity;
import com.webapplication.entity.EventDateEntity;
import com.webapplication.entity.ParentEntity;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mary on 1/7/2017.
 */

@Component
public class BookingMapper {
	public BookingEntity bookingEntityFromBookingRequestDto(NewBookingRequestDto newBookingRequestDto, ParentEntity parentEntity, EventDateEntity eventDateEntity){
		BookingEntity bookingEntity = new BookingEntity();

		bookingEntity.setNumOfTickets(newBookingRequestDto.getNumOfTickets());
		bookingEntity.setTotal_price(newBookingRequestDto.getNumOfTickets()*eventDateEntity.getEvent().getTicket_price());
		bookingEntity.setEventDate(eventDateEntity);
		bookingEntity.setParent(parentEntity);

		return bookingEntity;
	}

	public HashSet<BookingDto> bookingDtosFromBookingEntities(Set<BookingEntity> bookingEntities){
		HashSet<BookingDto> bookingDtos = new HashSet<>(bookingEntities.size());
		for (BookingEntity bookingEntity : bookingEntities){
			BookingDto bookingDto = new BookingDto();
			bookingDto.setId(bookingEntity.getId());
			bookingDto.setNumOfTickets(bookingEntity.getNumOfTickets());
			bookingDto.setTotal_price(bookingEntity.getTotal_price());
			bookingDto.setBooking_time(bookingEntity.getBooking_time());
			bookingDto.setEvent_id(bookingEntity.getEventDate().getEvent().getId());
			bookingDto.setEventDate_id(bookingEntity.getEventDate().getId());
			bookingDto.setEvent_name(bookingEntity.getEventDate().getEvent().getName());
			bookingDtos.add(bookingDto);
		}

		return bookingDtos;
	}
}
