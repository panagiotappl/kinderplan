package com.webapplication.dao;

import com.webapplication.entity.ParentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ParentRepository extends JpaRepository<ParentEntity, Long> {

    ParentEntity findParentByUserId(int id);

}