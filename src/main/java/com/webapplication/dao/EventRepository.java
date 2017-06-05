package com.webapplication.dao;

import com.webapplication.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by mary on 5/6/2017.
 */

@Repository
public interface EventRepository {
	EventEntity findEventsById(int id);
}
