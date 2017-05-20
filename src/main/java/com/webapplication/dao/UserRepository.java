package com.webapplication.dao;
import com.webapplication.entities.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<UsersEntity, Long> {

    UsersEntity findUserById(int id);
    UsersEntity findUserByEmailAndPassword(String email, String password);

}