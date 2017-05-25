package com.webapplication.dao;

import com.webapplication.entities.Providers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProviderRepository extends JpaRepository<Providers, Long> {




}