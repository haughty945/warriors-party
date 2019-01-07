package com.mine.warriorsservercommon.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author : mine_lee
 * @Date : 2019-01-08
 * @Remark :【请求日志】实体类
 */
@Data
public class LogServlet {

    /**
     * 主键
     */
    private Long id;

    /**
     * cookie标识
     */
    private String cookieValue;

    /**
     * 请求方式
     */
    private String requestMethod;

    /**
     * 请求Ip
     */
    private String requestIp;

    /**
     * 接口端口
     */
    private Integer requestPort;

    /**
     * 接口地址
     */
    private String requestUri;

    /**
     * java方法
     */
    private String javaClassMethod;

    /**
     * 请求参数
     */
    private String requestArgs;

    /**
     * 返回结果
     */
    private String responseArg;

    /**
     * 是否发生异常 0.否 1.是
     */
    private Integer exceptionFlag;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 逻辑删除
     */
    private Integer deleteFlag;

}
