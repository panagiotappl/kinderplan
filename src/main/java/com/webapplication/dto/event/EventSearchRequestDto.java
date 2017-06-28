package com.webapplication.dto.event;

import java.sql.Timestamp;

/**
 * Created by dimitris on 6/28/2017.
 */
public class EventSearchRequestDto {
    private String name;
    private String provider;
    private Integer km;
    private Timestamp date_ending;
    private Timestamp date_starting;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public Integer getKm() {
        return km;
    }

    public void setKm(Integer km) {
        this.km = km;
    }

    public Timestamp getDate_ending() {
        return date_ending;
    }

    public void setDate_ending(Timestamp date_ending) {
        this.date_ending = date_ending;
    }

    public Timestamp getDate_starting() {
        return date_starting;
    }

    public void setDate_starting(Timestamp date_starting) {
        this.date_starting = date_starting;
    }

}
