package com.mine.warriorsservermongodb.dao;

import com.mine.warriorsservermongodb.entity.Logger;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @program: warriors-party
 * @description: 日志映射层
 * @author: Mine.Lee
 * @create: 2019-01-22 18:30
 * @version: v1.0
 * @remark: ..
 */
@Repository
public interface LogRepository extends MongoRepository<Logger, UUID> {
}
