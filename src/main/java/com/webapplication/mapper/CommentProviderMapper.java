package com.webapplication.mapper;

import com.webapplication.dto.user.SubmitProviderCommentRequestDto;
import com.webapplication.entity.CommentProviderEntity;
import com.webapplication.entity.ParentEntity;
import com.webapplication.entity.ProviderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
}
