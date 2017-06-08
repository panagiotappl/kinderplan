package com.webapplication.controller;

import com.webapplication.dao.EventRepository;
import com.webapplication.dto.event.*;
import com.webapplication.entity.EventEntity;
import com.webapplication.error.user.UserError;
import com.webapplication.exception.ValidationException;
import com.webapplication.mapper.EventMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by mary on 5/6/2017.
 */

@Component
public class EventControllerImpl implements EventController{
	@Autowired
	private EventRepository eventRepository;
	@Autowired
	private EventMapper eventMapper;

	@Override
	public EventResponseDto getEvent(@PathVariable Integer eventId) throws Exception {
		Optional.ofNullable(eventId).orElseThrow(() -> new ValidationException(UserError.MISSING_DATA));

		//Get EventEntity
		EventEntity event = eventRepository.findEventsById(eventId);
		return  eventMapper.eventToEventResponse(event);
	}
}
