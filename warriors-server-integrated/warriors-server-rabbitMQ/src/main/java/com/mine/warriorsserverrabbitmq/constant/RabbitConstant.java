package com.mine.warriorsserverrabbitmq.constant;

/**
 * @program: warriors-party
 * @description: 常量配置类
 * @author: Mine.Lee
 * @create: 2019-01-16 01:52
 * @version: v1.0
 */
public class RabbitConstant {

    /**
     *  Exchange：消息交换机,它指定消息按什么规则,路由到哪个队列.
     */
    public static final String EXCHANGE_A = "my-mq-exchange_A";
    public static final String EXCHANGE_B = "my-mq-exchange_B";
    public static final String EXCHANGE_C = "my-mq-exchange_C";

    /**
     * Queue:消息的载体,每个消息都会被投到一个或多个队列.
     */
    public static final String QUEUE_A = "QUEUE_A";
    public static final String QUEUE_B = "QUEUE_B";
    public static final String QUEUE_C = "QUEUE_C";

    /**
     * 路由关键字,exchange根据这个关键字进行消息投递.
     */
    public static final String ROUTINGKEY_A = "spring-boot-routingKey_A";
    public static final String ROUTINGKEY_B = "spring-boot-routingKey_B";
    public static final String ROUTINGKEY_C = "spring-boot-routingKey_C";

}
