package com.webapplication.validator.ValidatorWrapper;

import com.webapplication.dto.event.EventSubmitRequestDto;
import com.webapplication.exception.ValidationException;

/**
 * Created by mary on 11/6/2017.
 */
public interface EventRequestValidatorWrapper {
	void validate(EventSubmitRequestDto eventSubmitRequestDto) throws ValidationException;
}
