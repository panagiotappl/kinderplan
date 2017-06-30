package com.webapplication.dao.elasticRepository;

import com.webapplication.elasticEntity.ElasticEventEntity;
import com.webapplication.entity.EventEntity;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


import java.util.ArrayList;
import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.multiMatchQuery;

/**
 * Created by dimitris on 6/27/2017.
 */
public interface ElasticEventRepository extends ElasticsearchRepository<ElasticEventEntity,String> {



    @Query("\"{\"bool\" : {\"must\" : {\"field\" : {\"name\" : \"?\"}}}}")
    Page<ElasticEventEntity> findByText(String name,Pageable pageable);
    ArrayList findByName(String name);
    List<ElasticEventEntity> findByProvider(String provider);
}
