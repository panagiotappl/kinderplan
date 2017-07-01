package com.webapplication.elasticEntity;

import org.springframework.data.elasticsearch.annotations.Document;

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




    public ElasticEventEntity() {}

    public ElasticEventEntity(String id, String name,String description, String providerName,String company) {
        this.id = id;
        this.name = name;
        this.description=description;
        this.providerName = providerName;
        this.company = company;
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
