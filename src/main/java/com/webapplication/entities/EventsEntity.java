package com.webapplication.entities;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by dimitris on 5/18/2017.
 */
@Entity
@Table(name = "Events", schema = "public", catalog = "kinderplan_db")
public class EventsEntity {
    private Integer id;
    private String name;
    private String address;
    private Double longitude;
    private Double latitude;
    private Integer ageFrom;
    private Integer ageTo;
    private Integer ticketPrice;
    private String description;
    private Timestamp dateCreated;
    private Timestamp dateEnding;
    private Timestamp dateStarting;

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
    @Column(name = "address", nullable = false, length = -1)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
    @Column(name = "age_from", nullable = false)
    public Integer getAgeFrom() {
        return ageFrom;
    }

    public void setAgeFrom(Integer ageFrom) {
        this.ageFrom = ageFrom;
    }

    @Basic
    @Column(name = "age_to", nullable = false)
    public Integer getAgeTo() {
        return ageTo;
    }

    public void setAgeTo(Integer ageTo) {
        this.ageTo = ageTo;
    }

    @Basic
    @Column(name = "ticket_price", nullable = false)
    public Integer getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Integer ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Basic
    @Column(name = "description", nullable = false, length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "date_created", nullable = false)
    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Basic
    @Column(name = "date_ending", nullable = false)
    public Timestamp getDateEnding() {
        return dateEnding;
    }

    public void setDateEnding(Timestamp dateEnding) {
        this.dateEnding = dateEnding;
    }

    @Basic
    @Column(name = "date_starting", nullable = false)
    public Timestamp getDateStarting() {
        return dateStarting;
    }

    public void setDateStarting(Timestamp dateStarting) {
        this.dateStarting = dateStarting;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventsEntity that = (EventsEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (longitude != null ? !longitude.equals(that.longitude) : that.longitude != null) return false;
        if (latitude != null ? !latitude.equals(that.latitude) : that.latitude != null) return false;
        if (ageFrom != null ? !ageFrom.equals(that.ageFrom) : that.ageFrom != null) return false;
        if (ageTo != null ? !ageTo.equals(that.ageTo) : that.ageTo != null) return false;
        if (ticketPrice != null ? !ticketPrice.equals(that.ticketPrice) : that.ticketPrice != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (dateCreated != null ? !dateCreated.equals(that.dateCreated) : that.dateCreated != null) return false;
        if (dateEnding != null ? !dateEnding.equals(that.dateEnding) : that.dateEnding != null) return false;
        if (dateStarting != null ? !dateStarting.equals(that.dateStarting) : that.dateStarting != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (ageFrom != null ? ageFrom.hashCode() : 0);
        result = 31 * result + (ageTo != null ? ageTo.hashCode() : 0);
        result = 31 * result + (ticketPrice != null ? ticketPrice.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        result = 31 * result + (dateEnding != null ? dateEnding.hashCode() : 0);
        result = 31 * result + (dateStarting != null ? dateStarting.hashCode() : 0);
        return result;
    }
}
