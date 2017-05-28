package com.webapplication.entities;


import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by KechagiasKonstantinos on 28/05/2017.
 */
@Entity
public class Parent {
    @Id
    Long parent_id;
    String email;
    String password;

    public Parent(){}

    public Parent(Long parent_id, String email, String password) {
        this.parent_id = parent_id;
        this.email = email;
        this.password = password;
    }

    public Long getParent_id() {
        return parent_id;
    }

    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
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
}
