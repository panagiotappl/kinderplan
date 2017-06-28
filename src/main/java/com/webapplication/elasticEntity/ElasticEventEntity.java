package com.webapplication.elasticEntity;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by dimitris on 6/27/2017.
 */

@Document(indexName = "kinderplan", type = "testEvents")
public class ElasticEventEntity {
    String id;
    String name;
    String provider;

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

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
}
