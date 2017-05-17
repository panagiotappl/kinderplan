package com.kinderplan.technologiaLogismikou.dbEntities;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by dimitris on 5/16/2017.
 */
@Entity
@Table(name = "Comments_Provider", schema = "public", catalog = "kinderplan_db")
public class entityCommentsProvider {
    private Integer id;
    private String comment;
    private Integer provider;
    private Timestamp date;
    private Integer userId;
    private entityProviders providersByProvider;
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
    @Column(name = "provider", nullable = false)
    public Integer getProvider() {
        return provider;
    }

    public void setProvider(Integer provider) {
        this.provider = provider;
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

        entityCommentsProvider that = (entityCommentsProvider) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (provider != null ? !provider.equals(that.provider) : that.provider != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (provider != null ? provider.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "provider", referencedColumnName = "id", nullable = false)
    public entityProviders getProvidersByProvider() {
        return providersByProvider;
    }

    public void setProvidersByProvider(entityProviders providersByProvider) {
        this.providersByProvider = providersByProvider;
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
