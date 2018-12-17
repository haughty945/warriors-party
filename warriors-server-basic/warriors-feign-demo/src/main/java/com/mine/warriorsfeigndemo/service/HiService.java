package com.mine.warriorsfeigndemo.service;

import com.mine.warriorsfeigndemo.service.Impl.HiHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author : john_lee
 * @Date : 2018/12/17
 * @Remark : TODO 描述
 */
@FeignClient(value = "WARRIORS-SERVER-ELEMENT",fallback = HiHystric.class)
public interface HiService {

    @RequestMapping(value = "hi",method = RequestMethod.GET)
    public String hi();
}
