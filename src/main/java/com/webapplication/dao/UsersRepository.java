package com.webapplication.dao;
import com.webapplication.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    Users findUserById(int id);
    Users findUserByEmailAndPassword(String email, String password);

}