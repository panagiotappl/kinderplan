package com.webapplication.dao.jpaRepository;

import com.webapplication.entity.ProviderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProviderRepository extends JpaRepository<ProviderEntity, Long> {

    ProviderEntity findProviderByUserId(int id);
    ProviderEntity findProviderById(Integer id);


}