package com.webapplication.validator.event;

import com.webapplication.dao.jpaRepository.EventDateRepository;
import com.webapplication.dao.jpaRepository.ParentRepository;
import com.webapplication.dto.event.NewBookingRequestDto;
import com.webapplication.error.event.NewBookingSubmitError;
import com.webapplication.exception.ValidationException;
import com.webapplication.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by mary on 1/7/2017.
 */

@Component
public class NewBookingValidator implements Validator <NewBookingRequestDto>{
	@Autowired
	private ParentRepository parentRepository;

	@Override
	public void validate(NewBookingRequestDto request) throws ValidationException {
		Optional.ofNullable(request).orElseThrow(() -> new ValidationException(NewBookingSubmitError.MISSING_DATA));
		Optional.ofNullable(request.getEventDate_id()).orElseThrow(() -> new ValidationException(NewBookingSubmitError.MISSING_EVENT));
		Optional.ofNullable(request.getNumOfTickets()).orElseThrow(() -> new ValidationException(NewBookingSubmitError.MISSING_TICKETS));
		Optional.ofNullable(request.getParent_id()).orElseThrow(() -> new ValidationException(NewBookingSubmitError.MISSING_PARENT));
		if (parentRepository.findParentByUserId(request.getParent_id()) == null){
			throw new ValidationException(NewBookingSubmitError.NOT_A_PARENT);
		}
	}

}
