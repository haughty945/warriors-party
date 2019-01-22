package com.mine.warriorsservermongodb.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

/**
 * @program: warriors-party
 * @description: 日志记录
 * @author: Mine.Lee
 * @create: 2019-01-22 17:20
 * @version: v1.0
 * @remark: ..
 */
@Document(collection = "warriors_logger")
@Data
public class Logger {

    private UUID uuid;
    private String request_Url;
    private String request_header;
    private String request_method;
    private String request_ip;
    private Integer request_port;
    private String request_uri;
    private String request_args;
    private String java_class_method;
    private String response_code;
    private String response_arg;
    private String error_detail;
}
