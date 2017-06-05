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
	@RequestMapping(path = "/user/{eventId}", method = RequestMethod.GET, produces = "application/json")
	EventResponseDto getEvent(@RequestHeader UUID authToken, @PathVariable Integer eventId) throws Exception;
}
