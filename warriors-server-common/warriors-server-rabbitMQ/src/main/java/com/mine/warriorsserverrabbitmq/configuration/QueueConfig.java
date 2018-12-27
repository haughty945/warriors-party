package com.mine.warriorsserverrabbitmq.configuration;

import com.mine.warriorsserverrabbitmq.Enum.RabbitConstant;
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
         * durable="true"   持久化.rabbitmq重启的时候不需要创建新的队列
         * auto-delete      表示消息队列没有在使用时将被自动删除 默认是false
         * exclusive        表示该消息队列是否只在当前connection生效,默认是false
         */
        return new Queue(RabbitConstant.QUEUE_A, true, false, false);
    }

    @Bean
    public Queue secondQueue() {
        return new Queue(RabbitConstant.QUEUE_B, true, false, false);
    }


}
