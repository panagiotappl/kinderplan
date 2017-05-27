package com.webapplication.dao;
import com.webapplication.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    Users findUsersById(int id);
    Users findUsersByName(String name);
    Users findUsersByEmail(String email);
    Users findUsersByEmailAndPassword(String email, String password);

}