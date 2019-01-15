package com.mine.warriorsserverrabbitmq.web;

import com.mine.warriorsserverrabbitmq.producer.ProducerOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: warriors-party
 * @description:
 * @author: Mine.Lee
 * @create: 2019-01-16 01:52
 * @version: v1.0
 */
@RestController
public class Controller {

    @Autowired
    private ProducerOne producerOne;

    @RequestMapping("hello")
    public String Test() {
        return producerOne.sendMsg();
    }
}
