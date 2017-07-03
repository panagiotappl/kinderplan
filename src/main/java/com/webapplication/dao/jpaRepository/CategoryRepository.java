package com.webapplication.dao.jpaRepository;

import com.webapplication.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Panos on 03/07/2017.
 */


@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    CategoryEntity findCategoryByCategory(String category);
}
