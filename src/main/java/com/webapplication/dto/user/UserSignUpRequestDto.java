package com.webapplication.dto.user;

import java.sql.Timestamp;

/**
 * Created by dimitris on 5/19/2017.
 */
public class UserSignUpRequestDto {
    private String name;
    private String surname;
    private String role;
    private String email;
    private String phone;
    private String address;
    private Double latitude;
    private Double longitude;
    private String password;
    private Timestamp createdDate;
    private ProviderRequestDto provider;
    private ParentRequestDto parent;

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public ParentRequestDto getParent() {
        return parent;
    }

    public void setParent(ParentRequestDto parent) {
        this.parent = parent;
    }



    public ProviderRequestDto getProvider() {
        return provider;
    }

    public void setProvider(ProviderRequestDto provider) {
        this.provider = provider;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }




}
