package com.webapplication.entities;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by dimitris on 5/18/2017.
 */
@Entity
@Table(name = "Transactions", schema = "public", catalog = "kinderplan_db")
public class TransactionsEntity {
    private Integer id;
    private Integer ammount;
    private Timestamp date;
    private ParentsEntity parentsByUser;
    private EventDatesEntity eventDatesByEvent;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ammount", nullable = false)
    public Integer getAmmount() {
        return ammount;
    }

    public void setAmmount(Integer ammount) {
        this.ammount = ammount;
    }

    @Basic
    @Column(name = "date", nullable = false)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionsEntity that = (TransactionsEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (ammount != null ? !ammount.equals(that.ammount) : that.ammount != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (ammount != null ? ammount.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "user", referencedColumnName = "id", nullable = false)
    public ParentsEntity getParentsByUser() {
        return parentsByUser;
    }

    public void setParentsByUser(ParentsEntity parentsByUser) {
        this.parentsByUser = parentsByUser;
    }

    @ManyToOne
    @JoinColumn(name = "event", referencedColumnName = "id")
    public EventDatesEntity getEventDatesByEvent() {
        return eventDatesByEvent;
    }

    public void setEventDatesByEvent(EventDatesEntity eventDatesByEvent) {
        this.eventDatesByEvent = eventDatesByEvent;
    }
}
