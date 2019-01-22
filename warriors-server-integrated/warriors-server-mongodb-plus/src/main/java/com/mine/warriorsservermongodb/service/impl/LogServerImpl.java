package com.mine.warriorsservermongodb.service.impl;

import com.alibaba.fastjson.JSON;
import com.mine.warriorsservermongodb.entity.Logger;
import com.mine.warriorsservermongodb.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @program: warriors-party
 * @description: 日志记录服务层
 * @author: Mine.Lee
 * @create: 2019-01-22 18:33
 * @version: v1.0
 * @remark: ..
 */
@Repository
public class LogServerImpl implements LogService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public String insert() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Logger logger = new Logger();
        logger.setUuid(UUID.randomUUID());
        logger.setRequest_Url(request.getRequestURL().toString());
        logger.setRequest_header(JSON.toJSONString(request.getHeaderNames()));
        logger.setRequest_method(request.getMethod());
        logger.setRequest_ip(request.getRemoteAddr());
        logger.setRequest_port(request.getRemotePort());
        logger.setRequest_uri(request.getRequestURI());
        logger.setRequest_args(JSON.toJSONString(request.getParameterNames()));
        mongoTemplate.insert(logger);
        return "success";
    }
}
