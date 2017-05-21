package com.webapplication.entities;

import javax.persistence.*;

/**
 * Created by dimitris on 5/21/2017.
 */
@Entity
public class Parents {
    private Integer id;
    private Integer points;
    private UsersEntity usersEntityByUserId;

    @Id
    @SequenceGenerator(name="parents_id_seq",
            sequenceName="parents_id_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="parents_id_seq")
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "points", nullable = false)
    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Parents parents = (Parents) o;

        if (id != null ? !id.equals(parents.id) : parents.id != null) return false;
        if (points != null ? !points.equals(parents.points) : parents.points != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (points != null ? points.hashCode() : 0);
        return result;
    }

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public UsersEntity getUsersEntityByUserId() {
        return usersEntityByUserId;
    }

    public void setUsersEntityByUserId(UsersEntity usersEntityByUserId) {
        this.usersEntityByUserId = usersEntityByUserId;
    }
}
