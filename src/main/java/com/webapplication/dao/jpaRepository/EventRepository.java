package com.webapplication.dao.jpaRepository;

import com.webapplication.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;


/**
 * Created by mary on 5/6/2017.
 */

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long>{
	EventEntity findEventsById(int id);
	EventEntity findEventsByNameAndProvider_idAndDateStarting(String name, int provider, Timestamp date_starting);
}
