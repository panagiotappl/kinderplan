package com.webapplication.dao;

import com.webapplication.entity.Parents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ParentRepository extends JpaRepository<Parents, Long> {



}