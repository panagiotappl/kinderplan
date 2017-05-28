package com.webapplication.dao;

import com.webapplication.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by KechagiasKonstantinos on 28/05/2017.
 */
public interface AdminRepository extends JpaRepository<Admin,Long> {
    Admin findByEmail(String email);
}

