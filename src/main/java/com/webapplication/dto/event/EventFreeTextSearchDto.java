package com.webapplication.dto.event;

/**
 * Created by dimitris on 6/30/2017.
 */
public class EventFreeTextSearchDto {
    private String text;
    private Integer distance;
    private Float lat;
    private Float lon;
    private String date_ending;
    private String date_starting;

    public Float getLon() {
        return lon;
    }

    public void setLon(Float lon) {
        this.lon = lon;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }



    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public String getDate_ending() {
        return date_ending;
    }

    public void setDate_ending(String date_ending) {
        this.date_ending = date_ending;
    }

    public String getDate_starting() {
        return date_starting;
    }

    public void setDate_starting(String date_starting) {
        this.date_starting = date_starting;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
