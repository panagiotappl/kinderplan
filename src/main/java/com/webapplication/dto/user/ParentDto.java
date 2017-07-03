package com.webapplication.dto.user;

import java.util.HashSet;

/**
 * Created by dimitris on 5/29/2017.
 */
public class ParentDto {
    private Integer parent_id;
    private Integer points;
    private HashSet<BookingDto> bookings;

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public HashSet<BookingDto> getBookings() {
        return bookings;
    }

    public void setBookings(HashSet<BookingDto> bookings) {
        this.bookings = bookings;
    }
}
