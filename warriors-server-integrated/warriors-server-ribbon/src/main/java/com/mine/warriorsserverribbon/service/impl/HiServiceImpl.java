package com.mine.warriorsserverribbon.service.impl;

import com.mine.warriorsservercommon.utils.RestTemplateUtil;
import com.mine.warriorsserverribbon.service.HiService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
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
    private RestTemplate restTemplateUtil;

    @Override
    @HystrixCommand(fallbackMethod = "hiError")
    public Object hi() {
        String url = "http://WARRIORS-SERVER-AOP/hello/test1";
        ResponseEntity<Object> entity = restTemplateUtil.exchange(url, HttpMethod.GET, null, Object.class);
        return entity.getBody();
    }

    public Object hiError() {
        return "目标服务宕机";
    }
}
