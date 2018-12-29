package com.mine.warriorsserverredis.web;

import com.mine.warriorsserverredis.entity.Person;
import com.mine.warriorsserverredis.utils.RedisTemplateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class RedisController {

    @Autowired
    private RedisTemplateUtils redisTemplateUtils;

    @GetMapping("hello1")
    public String test1() {
        Person person = new Person();
        person.setId(1);
        person.setName("张三");
        person.setCode(String.valueOf(UUID.randomUUID()));
        try {
            redisTemplateUtils.setValueForKey("测试", person);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "SUCCESS";
    }

    @GetMapping("hello2")
    public Object test2() {
        return redisTemplateUtils.getValueForKey("测试");
    }


}
