package com.webapplication.dao;
import com.webapplication.entities.UsersEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface UserRepository extends CrudRepository<UsersEntity, Long> {

    List<UsersEntity> findAll();
  //  Users findUserByUserId(int userId);


    UsersEntity findUserByEmailAndPassword(String email, String password);
}