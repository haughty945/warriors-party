package com.mine.warriorsserverrabbitmq.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;

/**
 * @Author : john_lee
 * @Date : 2018/12/23
 * @Remark : 消息确认配置
 */
@Slf4j
public class MsgSendConfirmCallBack implements RabbitTemplate.ConfirmCallback {

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {
            log.info("消息发送成功:id为" + correlationData.getId());
        } else {
            log.error("消息发送失败:id为" + correlationData.getId());
        }
    }
}