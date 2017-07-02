package com.webapplication.dao.jpaRepository;

import com.webapplication.entity.EventPhotosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Panos on 02/07/2017.
 */
@Repository
public interface PhotosRepository extends JpaRepository<EventPhotosEntity, Long>{
    List<EventPhotosEntity> findAll();
}

