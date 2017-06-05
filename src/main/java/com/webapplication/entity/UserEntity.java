package com.webapplication.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(
        name="user_entity",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"email"})
)
public class UserEntity {

    @Id
    @SequenceGenerator(name = "users_id_seq",
            sequenceName = "users_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "users_id_seq")
    @Column(name = "id", nullable = false)
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Boolean validated;
    private Timestamp createdDate;
    private Timestamp updatedDate;
    private Timestamp lastLogin;
    private String role;
    private String salt;

    public UserEntity(){
    }

    public UserEntity( String email, String name, String surname, String password, String role, Boolean validated){
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.role=role;
        this.validated=validated;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getValidated() {
        return validated;
    }

    public void setValidated(Boolean validated) {
        this.validated = validated;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
