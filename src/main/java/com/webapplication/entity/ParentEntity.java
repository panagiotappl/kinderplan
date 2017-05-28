package com.webapplication.entity;

import javax.persistence.*;

/**
 * Created by dimitris on 5/21/2017.
 */
@Entity
public class Parent {
    @Id
    private Integer id;
    private Integer points;
    @OneToOne
    private UserEntity user;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity userByUserId) {
        this.user = userByUserId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

}
