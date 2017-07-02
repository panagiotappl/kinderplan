package com.webapplication.validator.user;

import com.webapplication.dao.jpaRepository.ParentRepository;
import com.webapplication.dto.user.SubmitProviderCommentRequestDto;
import com.webapplication.entity.ParentEntity;
import com.webapplication.error.user.ProviderCommentSubmitError;
import com.webapplication.exception.ValidationException;
import com.webapplication.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by mary on 2/7/2017.
 */

@Component
public class ProviderCommentValidator implements Validator<SubmitProviderCommentRequestDto> {
	@Autowired
	private ParentRepository parentRepository;


	@Override
	public void validate(SubmitProviderCommentRequestDto request) throws ValidationException{
		Optional.ofNullable(request).orElseThrow(() -> new ValidationException(ProviderCommentSubmitError.MISSING_DATA));
		Optional.ofNullable(request.getComment()).orElseThrow(() -> new ValidationException(ProviderCommentSubmitError.MISSING_COMMENT));
		Optional.ofNullable(request.getProvider_id()).orElseThrow(() -> new ValidationException(ProviderCommentSubmitError.MISSING_PROVIDER));
		Optional.ofNullable(request.getUser_id()).orElseThrow(() -> new ValidationException(ProviderCommentSubmitError.MISSING_USER));

		if (parentRepository.findParentByUserId(request.getUser_id()) == null){
			throw new ValidationException(ProviderCommentSubmitError.NOT_A_PARENT);
		}
	}

}
