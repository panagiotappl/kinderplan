package com.webapplication.dto;


import java.util.UUID;


public class UserLogInResponseDto {

    public Long userId;

    public String role;

    public UUID generatedToken;

    public UUID getGeneratedToken() {
        return generatedToken;
    }

    public void setGeneratedToken(UUID generatedToken) {
        this.generatedToken = generatedToken;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserLogInResponseDto{" +
                "userId=" + userId +
                ", role='" + role + '\'' +
                ", generatedToken=" + generatedToken +
                '}';
    }
}
