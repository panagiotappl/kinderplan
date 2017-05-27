package com.webapplication.dto.user;

import org.joda.time.DateTime;

public class SessionInfo {

    private final Integer userId;
    private DateTime date;
    private final String role;

    public SessionInfo(Integer userId, DateTime date, String role) {
        this.userId = userId;
        this.date = date;
        this.role = role;
    }

    public Integer getUserId() {
        return userId;
    }

    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }

    public String getRole() {
        return role;
    }

}
