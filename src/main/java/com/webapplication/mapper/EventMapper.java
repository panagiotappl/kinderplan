package com.webapplication.mapper;

import com.webapplication.dto.event.*;
import com.webapplication.entity.EventEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mary on 5/6/2017.
 */

@Component
public class EventMapper {
	@Autowired
	private EventDateMapper eventDateMapper;
	@Autowired
	private CategoryMapper categoryMapper;
	@Autowired
	private CommentEventMapper commentEventMapper;
	@Autowired
	private EventPhotoMapper eventPhotoMapper;
	@Autowired
	private UserMapper userMapper;

	public EventResponseDto eventToEventResponse(EventEntity event){
		if (event == null)
			return null;

		EventResponseDto eventResponse = new EventResponseDto();
		eventResponse.setId(event.getId());
		eventResponse.setName(event.getName());
		eventResponse.setAddress(event.getAddress());
		eventResponse.setProvider(userMapper.providerViewEventDtoFromProviderEntity(event.getProvider()));
		eventResponse.setLongitude(event.getLongitude());
		eventResponse.setLatitude(event.getLatitude());
		eventResponse.setAge_from(event.getAge_from());
		eventResponse.setAge_to(event.getAge_to());
		eventResponse.setTicket_price(event.getTicket_price());
		eventResponse.setDescription(event.getDescription());
		eventResponse.setDate_starting(event.getDate_starting());
		eventResponse.setDate_ending(event.getDate_ending());
		eventResponse.setDates(eventDateMapper.eventDateDtosFromEventDateEntities(event.getDates()));
		eventResponse.setComments(commentEventMapper.commentEventDtosFromCommentEventEntities(event.getComments()));
		eventResponse.setCategories(categoryMapper.categoryDtosFromCategoryEntities(event.getCategories()));
		eventResponse.setPhotos(eventPhotoMapper.eventPhotosDtosFromEventPhotosEntities(event.getPhotos()));
		return eventResponse;
	}

	public EventEntity eventEntityFromEventDto(EventSubmitRequestDto eventSubmitRequestDto){
		EventEntity eventEntity= new EventEntity();
		eventEntity.setName(eventSubmitRequestDto.getName());
		eventEntity.setAddress(eventSubmitRequestDto.getAddress());
		eventEntity.setLongitude(eventSubmitRequestDto.getLongitude());
		eventEntity.setLatitude(eventSubmitRequestDto.getLatitude());
		eventEntity.setAge_from(eventSubmitRequestDto.getAge_from());
		eventEntity.setAge_to(eventSubmitRequestDto.getAge_to());
		eventEntity.setTicket_price(eventSubmitRequestDto.getTicket_price());
		eventEntity.setDescription(eventSubmitRequestDto.getDescription());
		eventEntity.setDate_ending(eventSubmitRequestDto.getDate_ending());
		eventEntity.setDate_starting(eventSubmitRequestDto.getDate_starting());
		eventEntity.setCategories(categoryMapper.categoryEntityFromCategoryDto(eventSubmitRequestDto.getCategories()));
		eventEntity.setComments(null);
		eventEntity.setDates(eventDateMapper.eventDateEntitiyFromEventDateDto(eventSubmitRequestDto.getDates()));
		return eventEntity;
	}

	public HashSet<EventProfileDto> eventProfileDtosFromEventEntities(Set<EventEntity> eventEntities){
		HashSet<EventProfileDto> eventProfileDtos = new HashSet<>(eventEntities.size());
		for (EventEntity eventEntity : eventEntities){
			EventProfileDto eventDto = new EventProfileDto();
			eventDto.setId(eventEntity.getId());
			eventDto.setName(eventEntity.getName());
			eventDto.setDescription(eventEntity.getDescription());
			eventDto.setPhoto(eventPhotoMapper.eventPhotosDtoFromFirstEventPhotosEntitiy(eventEntity.getPhotos()));
			eventProfileDtos.add(eventDto);
		}
		return eventProfileDtos;
	}
}
