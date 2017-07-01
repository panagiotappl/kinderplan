package com.webapplication.validator.event;

import com.webapplication.dto.event.EventFreeTextSearchDto;
import com.webapplication.dto.event.EventSubmitRequestDto;
import com.webapplication.error.event.EventError;
import com.webapplication.error.event.EventSubmitError;
import com.webapplication.exception.ValidationException;
import com.webapplication.validator.Validator;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by dimitris on 6/30/2017.
 */
@Component
public class EventSearchValidator implements Validator<EventFreeTextSearchDto> {

    @Override
    public void validate(EventFreeTextSearchDto eventFreeTextSearchDto) throws ValidationException {
        Optional.ofNullable(eventFreeTextSearchDto).orElseThrow(() -> new ValidationException(EventSubmitError.MISSING_DATA));
        Optional.ofNullable(eventFreeTextSearchDto.getText()).orElseThrow(() -> new ValidationException(EventError.EMPTY_TEXT_SEARCH));



    }
}
