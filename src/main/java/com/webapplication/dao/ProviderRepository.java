package com.webapplication.dao;

import com.webapplication.entity.ProviderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProviderRepository extends JpaRepository<ProviderEntity, Long> {




}