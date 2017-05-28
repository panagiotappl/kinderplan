package com.webapplication.dao;

import com.webapplication.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by KechagiasKonstantinos on 28/05/2017.
 */
public interface EventRepository extends JpaRepository<Event,Long> {
}
