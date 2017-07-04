package com.webapplication.elasticEntity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.elasticsearch.annotations.*;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import java.util.Date;

/**
 * Created by dimitris on 6/27/2017.
 */

@Document(indexName = "kinderplan", type = "testEvents")
public class ElasticEventEntity {
    String id;
    String name;
    String providerName;
    String company;
    String description;


    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd")
    @Field(type = FieldType.Date, index = FieldIndex.not_analyzed, store = true,
            format = DateFormat.custom, pattern = "yyyy-MM-dd'")
    Date startingDate;
    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd")
    @Field(type = FieldType.Date, index = FieldIndex.not_analyzed, store = true,
            format = DateFormat.custom, pattern = "yyyy-MM-dd")
    Date endingDate;


    private GeoPoint location;

    public GeoPoint getLocation() {
        return location;
    }

    public void setLocation(GeoPoint location) {
        this.location = location;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    public ElasticEventEntity() {}

    public ElasticEventEntity(String id, String name,String description, String providerName,String company,Date startingDate,Date endingDate,GeoPoint location) {
        this.id = id;
        this.name = name;
        this.description=description;
        this.providerName = providerName;
        this.company = company;
        this.startingDate=startingDate;
        this.endingDate=endingDate;
        this.location=location;
    }



    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }
}
