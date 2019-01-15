package com.mine.warriorsserverrabbitmq.producer;

import com.mine.warriorsserverrabbitmq.constant.RabbitConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @program: warriors-party
 * @description: 消息生产者
 * @author: Mine.Lee
 * @create: 2019-01-16 01:52
 * @version: v1.0
 */
@Component
public class ProducerOne {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public String sendMsg() {
        String msg = "消息体";
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        this.rabbitTemplate.convertAndSend(RabbitConstant.EXCHANGE_A, RabbitConstant.ROUTINGKEY_A, msg, correlationData);
        return "SUCCESS";
    }
}
