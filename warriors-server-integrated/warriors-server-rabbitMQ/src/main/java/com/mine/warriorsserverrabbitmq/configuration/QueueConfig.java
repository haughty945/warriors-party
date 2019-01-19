package com.mine.warriorsserverrabbitmq.configuration;

import com.mine.warriorsserverrabbitmq.constant.RabbitConstant;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author : john_lee
 * @Date : 2018/12/23
 * @Remark : 队列配置
 */
@Component
public class QueueConfig {

    /**
     * 消息的载体
     *
     * @return 消息的载体, 每个消息都会被投到一个或多个队列.
     */
    @Bean
    public Queue firstQueue() {
        /**
         * name :           队列名称
         * durable=true     持久化队列
         * auto-delete      表示消息队列没有在使用时将被自动删除 默认是false
         * exclusive        排他队列:表示该消息队列是否只在当前connection生效,默认是false
         * exclusive 详解 :  :如果一个队列被声明为排他队列，该队列仅对首次申明它的连接可见，并在连接断开时自动删除
         * 1.排他队列是基于连接可见的，同一连接的不同信道是可以同时访问同一连接创建的排他队列
         * 2.“首次”，如果一个连接已经声明了一个排他队列，其他连接是不允许建立同名的排他队列的，这个与普通队列不同
         * 3.即使该队列是持久化的，一旦连接关闭或者客户端退出，该排他队列都会被自动删除的，这种队列适用于一个客户端发送读取消息的应用场景
         */
        return new Queue(RabbitConstant.QUEUE_A, true, false, false,null);
    }

    @Bean
    public Queue secondQueue() {
        return new Queue(RabbitConstant.QUEUE_B, true, false, false,null);
    }

    @Bean
    public Queue thirdQueue() {
        return new Queue(RabbitConstant.QUEUE_C, false, false, false,null);
    }


}
