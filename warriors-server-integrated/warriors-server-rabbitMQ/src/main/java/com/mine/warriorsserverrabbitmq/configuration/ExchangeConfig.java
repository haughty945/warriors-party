package com.mine.warriorsserverrabbitmq.configuration;

import com.mine.warriorsserverrabbitmq.constant.RabbitConstant;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author : john_lee
 * @Date : 2018/12/23
 * @Remark : 消息交换机配置
 */
@Component
public class ExchangeConfig {

    @Bean
    public DirectExchange directExchange() {
        DirectExchange directExchange = new DirectExchange(RabbitConstant.EXCHANGE_A, true, false);
        return directExchange;
    }
}
