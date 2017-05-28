package com.webapplication.entity;

import javax.persistence.*;

/**
 * Created by dimitris on 5/21/2017.
 */
@Entity
public class Provider {
    @Id
    private Integer id;
    private Integer vatNumber;
    private String companyName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(Integer vatNumber) {
        this.vatNumber = vatNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
