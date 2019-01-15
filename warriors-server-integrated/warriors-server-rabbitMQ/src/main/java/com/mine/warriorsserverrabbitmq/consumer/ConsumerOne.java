package com.mine.warriorsserverrabbitmq.consumer;

import com.mine.warriorsserverrabbitmq.constant.RabbitConstant;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: warriors-party
 * @description: 消息消费者
 * @author: Mine.Lee
 * @create: 2019-01-16 01:52
 * @version: v1.0
 */
@Component
public class ConsumerOne {

    @RabbitListener(queues = {RabbitConstant.QUEUE_A,RabbitConstant.QUEUE_B})
    public void receiver(String msg) {
        // 处理消息
        System.out.println("消费者端收到内容为 :" + msg);
    }

}
