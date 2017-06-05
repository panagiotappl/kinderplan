package com.webapplication.dto.user;


import java.sql.Timestamp;

public class UserResponseDto {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private Boolean validated;
    private Timestamp createdDate;
    private Timestamp updatedDate;
    private Timestamp lastLogin;
    private ParentDto parentDto;
    private ProviderDto providerDto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Boolean getValidated() {
        return validated;
    }

    public void setValidated(Boolean validated) {
        this.validated = validated;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    public ParentDto getParentDto() {
        return parentDto;
    }

    public void setParentDto(ParentDto parentDto) {
        this.parentDto = parentDto;
    }

    public ProviderDto getProviderDto() {
        return providerDto;
    }

    public void setProviderDto(ProviderDto providerDto) {
        this.providerDto = providerDto;
    }
}
