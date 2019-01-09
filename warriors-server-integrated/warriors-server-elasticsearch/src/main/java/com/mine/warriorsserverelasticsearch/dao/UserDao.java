package com.mine.warriorsserverelasticsearch.dao;

import com.mine.warriorsserverelasticsearch.entity.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserDao extends ElasticsearchRepository<User, Long> {
}
