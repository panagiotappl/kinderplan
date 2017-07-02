package com.webapplication.mapper;

import com.webapplication.dto.event.EventPhotosDto;
import com.webapplication.entity.EventPhotosEntity;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

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
		else {
			return null;
		}
	}

	public HashSet<EventPhotosDto> eventPhotosDtosFromEventPhotosEntities(Set<EventPhotosEntity> eventPhotosEntities){
		if (eventPhotosEntities != null){
			HashSet<EventPhotosDto> eventPhotosDtos = new HashSet<>(eventPhotosEntities.size());
			for (EventPhotosEntity eventPhotosEntity : eventPhotosEntities){
				EventPhotosDto eventPhotosDto = new EventPhotosDto();
				eventPhotosDto.setPath(eventPhotosEntity.getPhoto_path());
				eventPhotosDtos.add(eventPhotosDto);
			}
			return eventPhotosDtos;
		}
		else{
			return null;
		}
	}
}
