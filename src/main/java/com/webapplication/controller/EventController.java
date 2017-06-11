package com.webapplication.controller;

import com.webapplication.dto.event.*;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by mary on 5/6/2017.
 */

@RestController
@RequestMapping(path = "/api")
public interface EventController {
	@RequestMapping(path = "/event/{eventId}", method = RequestMethod.GET, produces = "application/json")
	EventResponseDto getEvent(@PathVariable Integer eventId) throws Exception;

	@RequestMapping(path = "/submitEvent", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	EventSubmitResponseDto submitEvent(@RequestHeader UUID authToken, EventSubmitRequestDto eventSubmitRequestDto) throws Exception;
}
