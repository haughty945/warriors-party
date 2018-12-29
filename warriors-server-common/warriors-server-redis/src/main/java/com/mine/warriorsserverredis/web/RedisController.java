package com.mine.warriorsserverredis.web;

import com.mine.warriorsserverredis.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class RedisController {

    /**
     *  redisTemplate 操作Object
     */
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     *  stringRedisTemplate是操作字符串
     */
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("hello1")
    public String test1() {
        Person person = new Person();
        person.setId(1);
        person.setName("张三");
        person.setCode(String.valueOf(UUID.randomUUID()));
        try {
            redisTemplate.opsForValue().set("测试",person);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "SUCCESS";
    }

    @GetMapping("hello2")
    public Object test2 () {
        return redisTemplate.opsForValue().get("测试");
    }



}
