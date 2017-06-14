package com.webapplication.mapper;

import com.webapplication.dto.event.EventPhotosDto;
import com.webapplication.entity.EventPhotosEntity;
import org.springframework.stereotype.Component;

import java.util.HashSet;

/**
 * Created by mary on 14/6/2017.
 */

@Component
public class EventPhotoMapper {
	public HashSet<EventPhotosEntity> eventPhotosEntitiyFromPhotoDto(HashSet<EventPhotosDto> eventPhotosDto){
		if (eventPhotosDto != null){
			HashSet<EventPhotosEntity> eventPhotosEntities= new HashSet<>(eventPhotosDto.size());
			for (EventPhotosDto eventPhoto : eventPhotosDto){
				EventPhotosEntity photoEntity = new EventPhotosEntity();
				photoEntity.setPhoto_path(eventPhoto.getPath());
				eventPhotosEntities.add(photoEntity);
			}

			return eventPhotosEntities;
		}
		else{
			return null;
		}
	}
}
