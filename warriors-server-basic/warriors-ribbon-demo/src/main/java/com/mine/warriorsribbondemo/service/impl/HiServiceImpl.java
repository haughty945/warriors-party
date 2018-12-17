package com.mine.warriorsribbondemo.service.impl;

import com.mine.warriorsribbondemo.service.HiService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author : john_lee
 * @Date : 2018/12/17
 * @Remark : TODO 描述
 */
@Service
public class HiServiceImpl implements HiService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "hiError")
    public String hi() {
        ResponseEntity<String> entity = restTemplate.getForEntity("http://WARRIORS-SERVER-ELEMENT/hi", String.class);
        return entity.getBody();
    }

    public String hiError() {
        return "目标服务宕机";
    }
}
