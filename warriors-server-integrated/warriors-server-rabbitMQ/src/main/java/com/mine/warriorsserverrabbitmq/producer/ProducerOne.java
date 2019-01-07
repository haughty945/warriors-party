package com.mine.warriorsserverrabbitmq.producer;

import com.mine.warriorsserverrabbitmq.constant.RabbitConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @Author : john_lee
 * @Date : 2018/12/23
 * @Remark : TODO 描述
 */
@Slf4j
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
