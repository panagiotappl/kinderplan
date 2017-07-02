package com.webapplication.validator.event;

import com.webapplication.dao.jpaRepository.ParentRepository;
import com.webapplication.dto.event.SubmitEventCommentRequestDto;
import com.webapplication.error.event.EventCommentSubmitError;
import com.webapplication.exception.ValidationException;
import com.webapplication.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by mary on 2/7/2017.
 */

@Component
public class EventCommentValidator implements Validator<SubmitEventCommentRequestDto> {
	@Autowired
	private ParentRepository parentRepository;


	@Override
	public void validate(SubmitEventCommentRequestDto request) throws ValidationException{
		Optional.ofNullable(request).orElseThrow(() -> new ValidationException(EventCommentSubmitError.MISSING_DATA));
		Optional.ofNullable(request.getComment()).orElseThrow(() -> new ValidationException(EventCommentSubmitError.MISSING_COMMENT));
		Optional.ofNullable(request.getEvent_id()).orElseThrow(() -> new ValidationException(EventCommentSubmitError.MISSING_EVENT));
		Optional.ofNullable(request.getUser_id()).orElseThrow(() -> new ValidationException(EventCommentSubmitError.MISSING_USER));

		if (parentRepository.findParentByUserId(request.getUser_id()) == null){
			throw new ValidationException(EventCommentSubmitError.NOT_A_PARENT);
		}
	}
}
