package com.webapplication.controller;

import com.webapplication.authentication.Authenticator;
import com.webapplication.dao.elasticRepository.ElasticEventRepository;
import com.webapplication.dao.jpaRepository.EventRepository;
import com.webapplication.dao.jpaRepository.ProviderRepository;
import com.webapplication.dto.event.*;
import com.webapplication.elasticEntity.ElasticEventEntity;
import com.webapplication.entity.EventEntity;
import com.webapplication.entity.ProviderEntity;
import com.webapplication.exception.ValidationException;
import com.webapplication.error.event.EventError;
import com.webapplication.error.user.UserError;
import com.webapplication.mapper.EventMapper;
import com.webapplication.validator.event.EventRequestValidator;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.sql.Timestamp;

import static org.elasticsearch.index.query.QueryBuilders.multiMatchQuery;

/**
 * Created by mary on 5/6/2017.
 */

@Component
public class EventControllerImpl implements EventController{
	@Autowired
	private EventRepository eventRepository;
	@Autowired
	private EventMapper eventMapper;
	@Autowired
	private EventRequestValidator eventRequestValidator;
	@Autowired
	private Authenticator authenticator;
	@Autowired
	private ProviderRepository providerRepository;
	@Autowired
	private ElasticEventRepository elasticEventRepository;


	@Override
	public EventResponseDto getEvent(@PathVariable Integer eventId) throws Exception {
		Optional.ofNullable(eventId).orElseThrow(() -> new ValidationException(EventError.MISSING_DATA));

		//Get EventEntity
		EventEntity event = eventRepository.findEventsById(eventId);
		return  eventMapper.eventToEventResponse(event);
	}

	@Override
	public EventSubmitResponseDto submitEvent(@RequestHeader UUID authToken, @RequestBody EventSubmitRequestDto eventSubmitRequestDto) throws Exception {

		Optional.ofNullable(authToken).orElseThrow(() -> new ValidationException(UserError.MISSING_DATA));
		if(eventSubmitRequestDto.getProvider() == null){
			System.out.println("null");
		}else{
			System.out.println(eventSubmitRequestDto.getProvider());
		}
		ProviderEntity providerEntity = providerRepository.findProviderByUserId(eventSubmitRequestDto.getProvider());
		if (authenticator.getSession(authToken).getUserId() != providerEntity.getUser().getId()){
			throw new ValidationException(UserError.UNAUTHORIZED);
		}
		eventRequestValidator.validate(eventSubmitRequestDto);

		EventEntity eventEntity= eventMapper.eventEntityFromEventDto(eventSubmitRequestDto);
		eventEntity.setProvider(providerEntity);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		eventEntity.setDate_created(timestamp);
		eventRepository.saveAndFlush(eventEntity);
		elasticEventRepository.save(new ElasticEventEntity(eventEntity.getId().toString(),eventEntity.getName(),eventEntity.getDescription(),eventEntity.getProvider().getUser().getName(),eventEntity.getProvider().getCompanyName()));
		EventSubmitResponseDto response = new EventSubmitResponseDto(HttpStatus.OK,"Event is registered succesfully");
		return  response;
	}

	@Override
	public List<ElasticEventEntity> searchEvents(@RequestBody EventFreeTextSearchDto eventFreeTextSearchDto) throws Exception {

		SearchQuery searchQuery = new NativeSearchQueryBuilder()
				.withQuery(multiMatchQuery(eventFreeTextSearchDto.getText())
						.field("name")
						.field("providerName")
						.field("company")
						.field("description")
						.type(MultiMatchQueryBuilder.Type.BEST_FIELDS).fuzziness(Fuzziness.TWO)
				)
				.build();
		return elasticEventRepository.search(searchQuery).getContent();



	}


}


