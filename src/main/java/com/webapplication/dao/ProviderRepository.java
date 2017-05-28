package com.webapplication.dao;

import com.webapplication.entities.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by KechagiasKonstantinos on 28/05/2017.
 */
public interface ProviderRepository extends JpaRepository<Provider,Long>{
    Provider findByEmail(String email);
}
