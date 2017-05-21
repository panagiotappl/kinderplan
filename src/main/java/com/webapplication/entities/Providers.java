package com.webapplication.entities;

import javax.persistence.*;

/**
 * Created by dimitris on 5/21/2017.
 */
@Entity
public class Providers {
    private Integer id;
    private Integer vatNumber;
    private String companyName;
    private UsersEntity usersEntityByUserId;

    @Id
    @SequenceGenerator(name="providers_id_seq",
            sequenceName="providers_id_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="providers_id_seq")
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "vat_number", nullable = false)
    public Integer getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(Integer vatNumber) {
        this.vatNumber = vatNumber;
    }

    @Basic
    @Column(name = "company_name", nullable = false, length = -1)
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Providers providers = (Providers) o;

        if (id != null ? !id.equals(providers.id) : providers.id != null) return false;
        if (vatNumber != null ? !vatNumber.equals(providers.vatNumber) : providers.vatNumber != null) return false;
        if (companyName != null ? !companyName.equals(providers.companyName) : providers.companyName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (vatNumber != null ? vatNumber.hashCode() : 0);
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        return result;
    }

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public UsersEntity getUsersEntityByUserId() {
        return usersEntityByUserId;
    }

    public void setUsersEntityByUserId(UsersEntity usersEntityByUserId) {
        this.usersEntityByUserId = usersEntityByUserId;
    }
}
