package com.webapplication.dao.jpaRepository;

import com.webapplication.entity.EventDateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mary on 1/7/2017.
 */

@Repository
public interface EventDateRepository extends JpaRepository<EventDateEntity, Long> {
	EventDateEntity findEventDateById(int id);
}
