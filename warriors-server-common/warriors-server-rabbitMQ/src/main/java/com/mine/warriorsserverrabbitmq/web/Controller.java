package com.mine.warriorsserverrabbitmq.web;

import com.mine.warriorsserverrabbitmq.producer.ProducerOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : john_lee
 * @Date : 2018/12/23
 * @Remark : TODO 描述
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
