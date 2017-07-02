package com.webapplication.controller;

import com.webapplication.authentication.Authenticator;
import com.webapplication.dao.elasticRepository.ElasticEventRepository;

import com.webapplication.dao.jpaRepository.*;
import com.webapplication.dto.event.*;
import com.webapplication.elasticEntity.ElasticEventEntity;
import com.webapplication.entity.*;
import com.webapplication.error.event.NewBookingSubmitError;
import com.webapplication.exception.ValidationException;
import com.webapplication.error.event.EventError;
import com.webapplication.error.user.UserError;
import com.webapplication.mapper.BookingMapper;
import com.webapplication.mapper.EventMapper;
import com.webapplication.validator.event.EventRequestValidator;
import com.webapplication.validator.event.NewBookingValidator;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.sql.Timestamp;

import static org.elasticsearch.index.query.QueryBuilders.multiMatchQuery;

/**
 * Created by mary on 5/6/2017.
 */

@Component
public class EventControllerImpl implements EventController{
	@Autowired
	private EventRepository eventRepository;
	@Autowired
	private EventDateRepository eventDateRepository;
	@Autowired
	private EventMapper eventMapper;
	@Autowired
	private BookingMapper bookingMapper;
	@Autowired
	private BookingRepository bookingRepository;
	@Autowired
	private EventRequestValidator eventRequestValidator;
	@Autowired
	private NewBookingValidator newBookingValidator;
	@Autowired
	private Authenticator authenticator;
	@Autowired
	private ProviderRepository providerRepository;
	@Autowired

	private ParentRepository parentRepository;
	@Autowired
	private ElasticEventRepository elasticEventRepository;


	@Override
	public EventResponseDto getEvent(@PathVariable Integer eventId) throws Exception {
		Optional.ofNullable(eventId).orElseThrow(() -> new ValidationException(EventError.MISSING_DATA));

		//Get EventEntity
		EventEntity event = eventRepository.findEventsById(eventId);
		return  eventMapper.eventToEventResponse(event);
	}

	@Override
	public EventSubmitResponseDto submitEvent(@RequestHeader UUID authToken, @RequestBody EventSubmitRequestDto eventSubmitRequestDto) throws Exception {
		System.out.println(eventSubmitRequestDto);
		Optional.ofNullable(authToken).orElseThrow(() -> new ValidationException(UserError.MISSING_DATA));

		eventRequestValidator.validate(eventSubmitRequestDto);
		ProviderEntity providerEntity = providerRepository.findProviderByUserId(eventSubmitRequestDto.getProvider());
		if (authenticator.getSession(authToken).getUserId() != providerEntity.getUser().getId()){
			throw new ValidationException(UserError.UNAUTHORIZED);
		}

		EventEntity eventEntity= eventMapper.eventEntityFromEventDto(eventSubmitRequestDto);
		eventEntity.setProvider(providerEntity);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		eventEntity.setDate_created(timestamp);
		eventRepository.saveAndFlush(eventEntity);
		elasticEventRepository.save(new ElasticEventEntity(eventEntity.getId().toString(),eventEntity.getName(),eventEntity.getDescription(),eventEntity.getProvider().getUser().getName(),eventEntity.getProvider().getCompanyName()));

		EventSubmitResponseDto response = new EventSubmitResponseDto(HttpStatus.OK,"Event registered succesfully");
		return  response;
	}

	@Override
	public List<ElasticEventEntity> searchEvents(@RequestBody EventFreeTextSearchDto eventFreeTextSearchDto) throws Exception {

		SearchQuery searchQuery = new NativeSearchQueryBuilder()
				.withQuery(multiMatchQuery(eventFreeTextSearchDto.getText())
						.field("name")
						.field("providerName")
						.field("company")
						.field("description")
						.type(MultiMatchQueryBuilder.Type.BEST_FIELDS).fuzziness(Fuzziness.TWO)
				)
				.build();
		return elasticEventRepository.search(searchQuery).getContent();



	}


	@Override
	public NewBookingResponseDto bookEvent(@RequestHeader UUID authToken, @RequestBody NewBookingRequestDto newBookingRequestDto) throws  Exception{

		Optional.ofNullable(authToken).orElseThrow(() -> new ValidationException(UserError.MISSING_DATA));
		newBookingValidator.validate(newBookingRequestDto);
		ParentEntity parentEntity = parentRepository.findParentByUserId(newBookingRequestDto.getParent_id());
		if (authenticator.getSession(authToken).getUserId() != parentEntity.getUser().getId()){
			throw new ValidationException(UserError.UNAUTHORIZED);
		}
		EventDateEntity eventDateEntity = eventDateRepository.findEventDateById(newBookingRequestDto.getEventDate_id());
		if (eventDateEntity == null){
			throw new ValidationException(NewBookingSubmitError.INVALID_DATA);
		}
		if (eventDateEntity.getAvailable_tickets() < newBookingRequestDto.getNumOfTickets()){
			throw new ValidationException(NewBookingSubmitError.NOT_ENOUGH_TICKETS);
		}
		if (parentEntity.getPoints() < eventDateEntity.getEvent().getTicket_price()*newBookingRequestDto.getNumOfTickets()){
			throw new ValidationException(NewBookingSubmitError.NOT_ENOUGH_POINTS);
		}

		parentEntity.setPoints(parentEntity.getPoints()-eventDateEntity.getEvent().getTicket_price()*newBookingRequestDto.getNumOfTickets());
		eventDateEntity.setAvailable_tickets(eventDateEntity.getAvailable_tickets() - newBookingRequestDto.getNumOfTickets());
		eventDateEntity.setTickets_sold(eventDateEntity.getTickets_sold() + newBookingRequestDto.getNumOfTickets());
		BookingEntity bookingEntity = bookingMapper.bookingEntityFromBookingRequestDto(newBookingRequestDto, parentEntity, eventDateEntity);
		bookingEntity.setBooking_time(new Timestamp(System.currentTimeMillis()));
		bookingRepository.saveAndFlush(bookingEntity);
		NewBookingResponseDto response = new NewBookingResponseDto(HttpStatus.OK, "Tickets successfully booked");

		return response;
	}

}


