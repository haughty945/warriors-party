package com.mine.warriorsservermybatisplus.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * @Table - 映射表名
 * @Id - 主键
 * @GeneratedValue(strategy=GenerationType.IDENTITY) - 自动递增生成
 * @Column(name = “dict_name”,columnDefinition=”varchar(100) COMMENT ‘字典名’”) - 字段名、类型、注释
 * @UpdateTimestamp - 更新时自动更新时间
 * @CreationTimestamp - 创建时自动更新时间
 * @Version - 版本号，更新时自动加1
 * @Column 详解 ：
 * https://blog.csdn.net/qq_16769857/article/details/80347459
 */
@Data
@Entity
@Table(name = "log_servlet")
public class LogServlet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自动递增生成
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = " bigint(10) COMMENT '主键' ")
    private Long id;

    @Column(name = "cookie_value", columnDefinition = " varchar(255) COMMENT 'cookie标识' ")
    private String cookieValue;

    @Column(name = "request_method", columnDefinition = " varchar(255) COMMENT '请求方式' ")
    private String requestUrl;

    @Column(name = "request_ip", columnDefinition = " varchar(255) COMMENT '请求Ip' ")
    private String requestIp;

    @Column(name = "request_port", columnDefinition = " int(5) COMMENT '接口端口' ")
    private Integer requestPort;

    @Column(name = "request_uri", columnDefinition = " varchar(255) COMMENT '接口地址' ")
    private String requestUri;

    @Column(name = "request_args", columnDefinition = " varchar(255) COMMENT '请求参数' ")
    private String requestArgs;

    @Column(name = "java_class_method", columnDefinition = " varchar(255) COMMENT 'java方法' ")
    private String javaClassMethod;

    @Column(name = "response_arg", columnDefinition = " varchar(255) COMMENT '返回结果' ")
    private String responseArg;

    @Column(name = "exception_flag", columnDefinition = " varchar(255) COMMENT '是否发生异常 0.否 1.是 ' ")
    private String exceptionFlag;

    @CreationTimestamp
    @Column(name = "create_date", updatable = false, columnDefinition = " TIMESTAMP COMMENT '创建时间' ")
    private Date createDate = new Date();

    @Column(name = "delete_flag", columnDefinition = " int(1) COMMENT '逻辑删除 0.否 1.是 ' ")
    private String deleteFlag;
}
