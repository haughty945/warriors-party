package com.mine.warriorsserverrabbitmq.consumer;

import com.mine.warriorsserverrabbitmq.constant.RabbitConstant;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author : john_lee
 * @Date   : 2018/12/23
 * @Remark : TODO 描述
 */
@Component
public class ConsumerOne {

    @RabbitListener(queues = {RabbitConstant.QUEUE_A,RabbitConstant.QUEUE_B})
    public void receiver(String msg) {
        // 处理消息
        System.out.println("消费者端收到内容为 :" + msg);
    }

}
