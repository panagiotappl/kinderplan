package com.webapplication.validator.event;

import com.webapplication.dao.jpaRepository.EventRepository;
import com.webapplication.dao.jpaRepository.ProviderRepository;
import com.webapplication.dto.event.EventSubmitRequestDto;
import com.webapplication.error.event.EventSubmitError;
import com.webapplication.exception.ValidationException;
import com.webapplication.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by mary on 11/6/2017.
 */

@Component
public class EventSubmitValidator implements Validator <EventSubmitRequestDto> {
	@Autowired
	private EventRepository eventRepository;
	@Autowired
	private ProviderRepository providerRepository;
	@Override
	public void validate(EventSubmitRequestDto request) throws ValidationException {
		Optional.ofNullable(request).orElseThrow(() -> new ValidationException(EventSubmitError.MISSING_DATA));
		Optional.ofNullable(request.getName()).orElseThrow(() -> new ValidationException(EventSubmitError.MISSING_NAME));
		Optional.ofNullable(request.getProvider()).orElseThrow(() -> new ValidationException(EventSubmitError.MISSING_PROVIDER));
		Optional.ofNullable(request.getAddress()).orElseThrow(() -> new ValidationException(EventSubmitError.MISSING_ADDRESS));
		Optional.ofNullable(request.getAge_from()).orElseThrow(() -> new ValidationException(EventSubmitError.MISSING_AGE_FROM));
		Optional.ofNullable(request.getAge_to()).orElseThrow(() -> new ValidationException(EventSubmitError.MISSING_AGE_TO));
		Optional.ofNullable(request.getTicket_price()).orElseThrow(() -> new ValidationException(EventSubmitError.MISSING_TICKETPRICE));
		Optional.ofNullable(request.getDescription()).orElseThrow(() -> new ValidationException(EventSubmitError.MISSING_DESCRIPTION));
		Optional.ofNullable(request.getDate_starting()).orElseThrow(() -> new ValidationException(EventSubmitError.MISSING_DATE_STARTING));
		Optional.ofNullable(request.getDate_ending()).orElseThrow(() -> new ValidationException(EventSubmitError.MISSING_DATE_ENDING));
		Optional.ofNullable(request.getCategories()).orElseThrow(() -> new ValidationException(EventSubmitError.MISSING_CATEGORY));
		Optional.ofNullable(request.getDates()).orElseThrow(() -> new ValidationException(EventSubmitError.MISSING_DATES));
		if (providerRepository.findProviderByUserId(request.getProvider()) == null) {
			throw new ValidationException(EventSubmitError.NOT_A_PROVIDER);
		}
		//if (eventRepository.findEventsByNameAndProviderAndDate_starting(request.getName(), request.getProvider(), request.getDate_starting())!=null){
		//	throw new ValidationException(EventSubmitError.EXISTING_EVENT);
		//}
	}
}
