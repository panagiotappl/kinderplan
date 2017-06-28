package com.webapplication.dao.elasticRepository;

import com.webapplication.elasticEntity.ElasticEventEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dimitris on 6/27/2017.
 */
public interface ElasticEventRepository extends ElasticsearchRepository<ElasticEventEntity,String> {
    ArrayList findByName(String name);
    List<ElasticEventEntity> findByProvider(String provider);

    Page<ElasticEventEntity> findByProvider(String provider, Pageable pageable);


}
