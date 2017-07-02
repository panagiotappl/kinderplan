package com.webapplication.dao.jpaRepository;

import com.webapplication.entity.ParentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ParentRepository extends JpaRepository<ParentEntity, Long> {

    ParentEntity findParentById(int id);
    ParentEntity findParentByUserId(int id);

}