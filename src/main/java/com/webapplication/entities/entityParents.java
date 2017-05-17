package com.webapplication.entities;

import java.util.Collection;

/**
 * Created by dimitris on 5/16/2017.
 */
@Entity
@Table(name = "Parents", schema = "public", catalog = "kinderplan_db")
public class entityParents {
    private Integer id;
    private String name;
    private String surname;
    private Double longitude;
    private Double latitude;
    private String phone;
    private Integer userId;
    private Integer points;
    private Collection<entityCommentsEvents> commentsEventssById;
    private Collection<entityCommentsProvider> commentsProvidersById;
    private entityUsers usersByUserId;
    private Collection<entityTransactions> transactionssById;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname", nullable = false, length = -1)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "longitude", nullable = false, precision = 0)
    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "latitude", nullable = false, precision = 0)
    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "phone", nullable = false, length = -1)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

        entityParents that = (entityParents) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (longitude != null ? !longitude.equals(that.longitude) : that.longitude != null) return false;
        if (latitude != null ? !latitude.equals(that.latitude) : that.latitude != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (points != null ? !points.equals(that.points) : that.points != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (points != null ? points.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "parentsByUserId")
    public Collection<entityCommentsEvents> getCommentsEventssById() {
        return commentsEventssById;
    }

    public void setCommentsEventssById(Collection<entityCommentsEvents> commentsEventssById) {
        this.commentsEventssById = commentsEventssById;
    }

    @OneToMany(mappedBy = "parentsByUserId")
    public Collection<entityCommentsProvider> getCommentsProvidersById() {
        return commentsProvidersById;
    }

    public void setCommentsProvidersById(Collection<entityCommentsProvider> commentsProvidersById) {
        this.commentsProvidersById = commentsProvidersById;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public entityUsers getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(entityUsers usersByUserId) {
        this.usersByUserId = usersByUserId;
    }

    @OneToMany(mappedBy = "parentsByUser")
    public Collection<entityTransactions> getTransactionssById() {
        return transactionssById;
    }

    public void setTransactionssById(Collection<entityTransactions> transactionssById) {
        this.transactionssById = transactionssById;
    }
}
