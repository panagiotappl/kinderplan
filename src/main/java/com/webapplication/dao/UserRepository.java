package com.webapplication.dao;
import com.webapplication.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(int id);
    User findUserByEmailAndPassword(String email, String password);

}