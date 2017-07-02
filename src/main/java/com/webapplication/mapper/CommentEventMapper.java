package com.webapplication.mapper;

import com.webapplication.dto.event.CommentEventDto;
import com.webapplication.dto.user.ParentCommentDto;
import com.webapplication.entity.CommentEventEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mary on 2/7/2017.
 */

@Component
public class CommentEventMapper {
	@Autowired
	private UserMapper userMapper;

	public HashSet<CommentEventDto> commentEventDtosFromCommentEventEntities(Set<CommentEventEntity> commentEventEntities){
		HashSet<CommentEventDto> commentEventDtos = new HashSet<>(commentEventEntities.size());
		for (CommentEventEntity commentEntity : commentEventEntities){
			CommentEventDto commentDto = new CommentEventDto();
			commentDto.setComment(commentEntity.getComment());
			commentDto.setDate(commentEntity.getDate());
			commentDto.setParent(userMapper.parentCommentDtoFromParentEntity(commentEntity.getParent()));
			commentEventDtos.add(commentDto);
		}
		return commentEventDtos;
	}

}
