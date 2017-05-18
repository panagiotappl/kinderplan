package com.webapplication.entities;

import javax.persistence.*;

/**
 * Created by dimitris on 5/18/2017.
 */
@Entity
@Table(name = "event_category", schema = "public", catalog = "kinderplan_db")
@IdClass(EventCategoryEntityPK.class)
public class EventCategoryEntity {
    private Integer eventId;
    private Integer categoryId;
    private CategoriesEntity categoriesByCategoryId;

    @Id
    @Column(name = "event_id", nullable = false)
    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    @Id
    @Column(name = "category_id", nullable = false)
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

        EventCategoryEntity that = (EventCategoryEntity) o;

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

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    public CategoriesEntity getCategoriesByCategoryId() {
        return categoriesByCategoryId;
    }

    public void setCategoriesByCategoryId(CategoriesEntity categoriesByCategoryId) {
        this.categoriesByCategoryId = categoriesByCategoryId;
    }
}
