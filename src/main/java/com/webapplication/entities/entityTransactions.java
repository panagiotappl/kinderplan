package com.webapplication.entities;

import java.sql.Timestamp;

/**
 * Created by dimitris on 5/16/2017.
 */
@Entity
@Table(name = "Transactions", schema = "public", catalog = "kinderplan_db")
public class entityTransactions {
    private Integer id;
    private Integer user;
    private Integer ammount;
    private Timestamp date;
    private Integer event;
    private entityParents parentsByUser;
    private entityEventDates eventDatesByEvent;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user", nullable = false)
    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
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

    @Basic
    @Column(name = "event", nullable = true)
    public Integer getEvent() {
        return event;
    }

    public void setEvent(Integer event) {
        this.event = event;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        entityTransactions that = (entityTransactions) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (ammount != null ? !ammount.equals(that.ammount) : that.ammount != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (event != null ? !event.equals(that.event) : that.event != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (ammount != null ? ammount.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (event != null ? event.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "user", referencedColumnName = "id", nullable = false)
    public entityParents getParentsByUser() {
        return parentsByUser;
    }

    public void setParentsByUser(entityParents parentsByUser) {
        this.parentsByUser = parentsByUser;
    }

    @ManyToOne
    @JoinColumn(name = "event", referencedColumnName = "id")
    public entityEventDates getEventDatesByEvent() {
        return eventDatesByEvent;
    }

    public void setEventDatesByEvent(entityEventDates eventDatesByEvent) {
        this.eventDatesByEvent = eventDatesByEvent;
    }
}
