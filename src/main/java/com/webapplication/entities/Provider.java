package com.webapplication.entities;


import javax.persistence.*;
import java.util.List;

/**
 * Created by KechagiasKonstantinos on 28/05/2017.
 */
@Entity
public class Provider {

    @Id
    Long prov_id;
    String email;
    String password;
    @OneToMany(cascade = CascadeType.PERSIST,orphanRemoval = true)
    List<Event> event;

    public Provider(){}

    public Provider(Long prov_id, String email, String password, List<Event> event) {
        this.prov_id = prov_id;
        this.email = email;
        this.password = password;
        this.event = event;
    }

    public Long getProv_id() {
        return prov_id;
    }

    public void setProv_id(Long prov_id) {
        this.prov_id = prov_id;
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

    public List<Event> getEvent() {
        return event;
    }

    public void setEvent(List<Event> event) {
        this.event = event;
    }









}
