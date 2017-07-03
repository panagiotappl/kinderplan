package com.webapplication.mapper;

import com.webapplication.dto.user.ProfileCommentProviderDto;
import com.webapplication.dto.user.SubmitProviderCommentRequestDto;
import com.webapplication.entity.CommentProviderEntity;
import com.webapplication.entity.ParentEntity;
import com.webapplication.entity.ProviderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mary on 2/7/2017.
 */

@Component
public class CommentProviderMapper {
	public CommentProviderEntity commentProviderEntityFromSubmitCommentProviderDto(SubmitProviderCommentRequestDto submitProviderCommentRequestDto, ParentEntity parentEntity, ProviderEntity providerEntity){
		CommentProviderEntity commentProviderEntity = new CommentProviderEntity();
		commentProviderEntity.setComment(submitProviderCommentRequestDto.getComment());
		commentProviderEntity.setParent(parentEntity);
		commentProviderEntity.setProvider(providerEntity);
		return commentProviderEntity;
	}

	public HashSet<ProfileCommentProviderDto> profileCommentProviderDtosFromCommentProviderEntities(Set<CommentProviderEntity> commentProviderEntities){
		HashSet<ProfileCommentProviderDto> profileCommentProviderDtos = new HashSet<>(commentProviderEntities.size());
		for (CommentProviderEntity commentEntity : commentProviderEntities){
			ProfileCommentProviderDto commentDto = new ProfileCommentProviderDto();
			commentDto.setComment(commentEntity.getComment());
			commentDto.setDate(commentEntity.getDate());
			commentDto.setParent_user_id(commentEntity.getParent().getUser().getId());
			commentDto.setParent_name(commentEntity.getParent().getUser().getName());
			commentDto.setParent_surname(commentEntity.getParent().getUser().getSurname());
			profileCommentProviderDtos.add(commentDto);
		}
		return profileCommentProviderDtos;
	}
}
