package com.webapplication.validator.ValidatorWrapper;

import com.webapplication.dto.event.SubmitEventCommentRequestDto;
import com.webapplication.exception.ValidationException;

/**
 * Created by mary on 2/7/2017.
 */
public interface CommentValidatorWrapper {
	void validate(SubmitEventCommentRequestDto submitEventCommentRequestDto) throws ValidationException;
	//void validate(SubmitProviderCommentRequestDto submitProviderCommentRequestDto) throws ValidationException;
}
