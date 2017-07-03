package com.webapplication.mapper;

import com.webapplication.dao.jpaRepository.CategoryRepository;
import com.webapplication.dto.CategoryDto;
import com.webapplication.entity.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mary on 14/6/2017.
 */

@Component
public class CategoryMapper {

	@Autowired
	private CategoryRepository categoryRepository;

	public HashSet<CategoryEntity> categoryEntityFromCategoryDto(HashSet<CategoryDto> categoriesDto){
		HashSet<CategoryEntity> categoryEntities = new HashSet<CategoryEntity>(categoriesDto.size());
		for (CategoryDto categoryDto : categoriesDto){
			CategoryEntity categoryEntity = new CategoryEntity();
			categoryEntity = categoryRepository.findCategoryByCategory(categoryDto.getCategory());
			categoryEntities.add(categoryEntity);
		}

		return categoryEntities;
	}

	public HashSet<CategoryDto> categoryDtosFromCategoryEntities(Set<CategoryEntity> categoryEntities){
		HashSet<CategoryDto> categoryDtos = new HashSet<>(categoryEntities.size());
		for (CategoryEntity categoryEntity : categoryEntities){
			CategoryDto categoryDto = new CategoryDto();
			categoryDto.setCategory(categoryEntity.getCategory());
			categoryDtos.add(categoryDto);
		}

		return categoryDtos;
	}
}
