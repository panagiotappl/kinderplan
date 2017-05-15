package com.kinderplan.technologiaLogismikou.dbEntities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by dimitris on 5/16/2017.
 */
@Entity
@Table(name = "Categories", schema = "public", catalog = "kinderplan_db")
public class entityCategories {
    private Integer id;
    private String category;
    private Collection<entityEventCategory> eventCategoriesById;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "category", nullable = false, length = -1)
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        entityCategories that = (entityCategories) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "categoriesByCategoryId")
    public Collection<entityEventCategory> getEventCategoriesById() {
        return eventCategoriesById;
    }

    public void setEventCategoriesById(Collection<entityEventCategory> eventCategoriesById) {
        this.eventCategoriesById = eventCategoriesById;
    }
}
