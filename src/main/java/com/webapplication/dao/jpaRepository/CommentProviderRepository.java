package com.webapplication.dao.jpaRepository;

import com.webapplication.entity.CommentProviderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mary on 2/7/2017.
 */

@Repository
public interface CommentProviderRepository extends JpaRepository<CommentProviderEntity, Long> {
}
