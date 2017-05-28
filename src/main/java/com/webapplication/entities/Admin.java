package com.webapplication.entities;


import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by KechagiasKonstantinos on 28/05/2017.
 */
@Entity
public class Admin {
    @Id
    Long admin_id;
    String email;
    String password;

    public Admin(){}

    public Admin(Long admin_id, String email, String password) {
        this.admin_id = admin_id;
        this.email = email;
        this.password = password;
    }

    public Long getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Long admin_id) {
        this.admin_id = admin_id;
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
