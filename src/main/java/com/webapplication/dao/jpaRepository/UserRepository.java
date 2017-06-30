package com.webapplication.dao.jpaRepository;
import com.webapplication.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findUsersById(int id);
    UserEntity findUsersByName(String name);
    UserEntity findUsersByEmail(String email);
    UserEntity findUsersByEmailAndPassword(String email, String password);

}