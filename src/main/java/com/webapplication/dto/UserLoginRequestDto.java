package com.webapplication.dto;

/**
 * Created by dimitris on 5/18/2017.
 */
public class UserLoginRequestDto {


    private String email;

    private String password;



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserLoginRequestDto{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

