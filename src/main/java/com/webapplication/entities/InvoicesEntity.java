package com.webapplication.entities;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by dimitris on 5/18/2017.
 */
@Entity
@Table(name = "Invoices", schema = "public", catalog = "kinderplan_db")
public class InvoicesEntity {
    private Integer id;
    private Float ammount;
    private Integer provider;
    private Timestamp dateIssued;
    private Timestamp dateSend;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ammount", nullable = false, precision = 0)
    public Float getAmmount() {
        return ammount;
    }

    public void setAmmount(Float ammount) {
        this.ammount = ammount;
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
    @Column(name = "date_issued", nullable = false)
    public Timestamp getDateIssued() {
        return dateIssued;
    }

    public void setDateIssued(Timestamp dateIssued) {
        this.dateIssued = dateIssued;
    }

    @Basic
    @Column(name = "date_send", nullable = false)
    public Timestamp getDateSend() {
        return dateSend;
    }

    public void setDateSend(Timestamp dateSend) {
        this.dateSend = dateSend;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvoicesEntity that = (InvoicesEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (ammount != null ? !ammount.equals(that.ammount) : that.ammount != null) return false;
        if (provider != null ? !provider.equals(that.provider) : that.provider != null) return false;
        if (dateIssued != null ? !dateIssued.equals(that.dateIssued) : that.dateIssued != null) return false;
        if (dateSend != null ? !dateSend.equals(that.dateSend) : that.dateSend != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (ammount != null ? ammount.hashCode() : 0);
        result = 31 * result + (provider != null ? provider.hashCode() : 0);
        result = 31 * result + (dateIssued != null ? dateIssued.hashCode() : 0);
        result = 31 * result + (dateSend != null ? dateSend.hashCode() : 0);
        return result;
    }
}
