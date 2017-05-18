package com.webapplication.entities;

/**
 * Created by dimitris on 5/16/2017.
 */
@Entity
@Table(name = "event_category", schema = "public", catalog = "kinderplan_db")
@IdClass(entityEventCategoryPK.class)
public class entityEventCategory {
    private Integer eventId;
    private Integer categoryId;
    private entityEvents eventsByEventId;
    private entityCategories categoriesByCategoryId;

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

        entityEventCategory that = (entityEventCategory) o;

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
    @JoinColumn(name = "event_id", referencedColumnName = "id", nullable = false)
    public entityEvents getEventsByEventId() {
        return eventsByEventId;
    }

    public void setEventsByEventId(entityEvents eventsByEventId) {
        this.eventsByEventId = eventsByEventId;
    }

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    public entityCategories getCategoriesByCategoryId() {
        return categoriesByCategoryId;
    }

    public void setCategoriesByCategoryId(entityCategories categoriesByCategoryId) {
        this.categoriesByCategoryId = categoriesByCategoryId;
    }
}
