package com.webapplication.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by dimitris on 5/16/2017.
 */
public class entityEventCategoryPK implements Serializable {
    private Integer eventId;
    private Integer categoryId;

    @Column(name = "event_id", nullable = false)
    @Id
    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    @Column(name = "category_id", nullable = false)
    @Id
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        entityEventCategoryPK that = (entityEventCategoryPK) o;

        if (eventId != null ? !eventId.equals(that.eventId) : that.eventId != null) return false;
        if (categoryId != null ? !categoryId.equals(that.categoryId) : that.categoryId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eventId != null ? eventId.hashCode() : 0;
        result = 31 * result + (categoryId != null ? categoryId.hashCode() : 0);
        return result;
    }
}
