package com.mine.warriorsserverrabbitmq.producer;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mine.warriorsservercommon.pojo.ResultVO;
import com.mine.warriorsserverrabbitmq.constant.RabbitConstant;
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

    public String sendMsg() throws JsonProcessingException {
        String msg = "消息体";
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        System.out.println("发生:" + correlationData.getId());
        String message = JSON.toJSONString(new ResultVO<>());
        this.rabbitTemplate.convertAndSend(RabbitConstant.EXCHANGE_A, RabbitConstant.ROUTINGKEY_A, message, correlationData);
        return "SUCCESS";
    }
}
