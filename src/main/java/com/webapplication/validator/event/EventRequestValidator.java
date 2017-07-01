package com.webapplication.validator.event;

import com.webapplication.dto.event.EventFreeTextSearchDto;
import com.webapplication.dto.event.EventSubmitResponseDto;
import com.webapplication.dto.event.EventSubmitRequestDto;
import com.webapplication.dto.user.UserSignUpRequestDto;
import com.webapplication.exception.ValidationException;
import com.webapplication.validator.ValidatorWrapper.EventRequestValidatorWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Created by mary on 11/6/2017.
 */

@Component
public class EventRequestValidator implements EventRequestValidatorWrapper {

	@Autowired
	private EventSubmitValidator eventSubmitValidator;

	@Autowired
	private EventSearchValidator eventSearchValidator;


	@Override
	public void validate(EventSubmitRequestDto eventSubmitRequestDto) throws ValidationException {
		eventSubmitValidator.validate(eventSubmitRequestDto);
	}

	@Override
	public void validate(EventFreeTextSearchDto eventFreeTextSearchDto) throws ValidationException {
		eventSearchValidator.validate(eventFreeTextSearchDto);
	}


}
