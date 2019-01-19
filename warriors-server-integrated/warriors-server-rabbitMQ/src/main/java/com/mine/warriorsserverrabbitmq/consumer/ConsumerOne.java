package com.mine.warriorsserverrabbitmq.consumer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mine.warriorsservercommon.pojo.ResultVO;
import com.mine.warriorsserverrabbitmq.constant.RabbitConstant;
import com.rabbitmq.tools.json.JSONUtil;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import springfox.documentation.spring.web.json.Json;

/**
 * @program: warriors-party
 * @description: 消息消费者
 * @author: Mine.Lee
 * @create: 2019-01-16 01:52
 * @version: v1.0
 */
@Component
public class ConsumerOne {

    @RabbitListener(queues = {RabbitConstant.QUEUE_A, RabbitConstant.QUEUE_B})
    public void receiver(@RequestBody Message msg) {
        byte[] body = msg.getBody();
        String message = new String(body);
        ResultVO s = JSONObject.parseObject(message, ResultVO.class);
        // 处理消息
        System.out.println("消费者端收到内容为 : " + s);
    }

}
