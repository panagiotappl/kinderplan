package com.webapplication.entities;

import java.sql.Timestamp;

/**
 * Created by dimitris on 5/16/2017.
 */
@Entity
@Table(name = "Comments_Events", schema = "public", catalog = "kinderplan_db")
public class entityCommentsEvents {
    private Integer id;
    private String comment;
    private Integer event;
    private Timestamp date;
    private Integer userId;
    private entityEvents eventsByEvent;
    private entityParents parentsByUserId;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "comment", nullable = false, length = -1)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "event", nullable = false)
    public Integer getEvent() {
        return event;
    }

    public void setEvent(Integer event) {
        this.event = event;
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
    @Column(name = "user_id", nullable = false)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        entityCommentsEvents that = (entityCommentsEvents) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (event != null ? !event.equals(that.event) : that.event != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (event != null ? event.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "event", referencedColumnName = "id", nullable = false)
    public entityEvents getEventsByEvent() {
        return eventsByEvent;
    }

    public void setEventsByEvent(entityEvents eventsByEvent) {
        this.eventsByEvent = eventsByEvent;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public entityParents getParentsByUserId() {
        return parentsByUserId;
    }

    public void setParentsByUserId(entityParents parentsByUserId) {
        this.parentsByUserId = parentsByUserId;
    }
}
