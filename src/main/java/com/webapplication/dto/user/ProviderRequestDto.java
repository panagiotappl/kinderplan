package com.webapplication.dto.user;

/**
 * Created by dimitris on 5/29/2017.
 */
public class ProviderRequestDto {
    private Integer vatNumber;
    private String companyName;

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
