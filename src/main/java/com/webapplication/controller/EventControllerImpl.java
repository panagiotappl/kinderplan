package com.webapplication.controller;

import com.webapplication.authentication.Authenticator;
import com.webapplication.dao.EventRepository;
import com.webapplication.dao.ProviderRepository;
import com.webapplication.dto.event.*;
import com.webapplication.dto.user.SessionInfo;
import com.webapplication.entity.EventEntity;
import com.webapplication.entity.ProviderEntity;
import com.webapplication.exception.ValidationException;
import com.webapplication.error.event.EventError;
import com.webapplication.error.user.UserError;
import com.webapplication.exception.user.NotAuthenticatedException;
import com.webapplication.mapper.EventMapper;
import com.webapplication.validator.event.EventRequestValidator;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.UUID;
import java.sql.Timestamp;

/**
 * Created by mary on 5/6/2017.
 */

@Component
public class EventControllerImpl implements EventController{
	@Autowired
	private EventRepository eventRepository;
	@Autowired
	private EventMapper eventMapper;
	@Autowired
	private EventRequestValidator eventRequestValidator;
	@Autowired
	private Authenticator authenticator;
	@Autowired
	private ProviderRepository providerRepository;

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
		ProviderEntity providerEntity = providerRepository.findProviderById(eventSubmitRequestDto.getProvider());
		if (authenticator.getSession(authToken).getUserId() != providerEntity.getUser().getId()){
			throw new ValidationException(UserError.UNAUTHORIZED);
		}
		eventRequestValidator.validate(eventSubmitRequestDto);

		EventEntity eventEntity= eventMapper.eventEntityFromEventDto(eventSubmitRequestDto);
		eventEntity.setProvider(providerEntity);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		eventEntity.setDate_created(timestamp);
		eventRepository.saveAndFlush(eventEntity);
		EventSubmitResponseDto response = new EventSubmitResponseDto(HttpStatus.OK,"Event is registered succesfully");
		return  response;
	}
}


