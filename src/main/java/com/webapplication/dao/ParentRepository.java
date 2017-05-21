package com.webapplication.dao;
import com.webapplication.entities.Parents;
import com.webapplication.entities.Providers;
import com.webapplication.entities.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ParentRepository extends JpaRepository<Parents, Long> {



}