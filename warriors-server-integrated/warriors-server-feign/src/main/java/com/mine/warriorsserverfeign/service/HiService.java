package com.mine.warriorsserverfeign.service;

import com.mine.warriorsserverfeign.service.Impl.HiHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author : john_lee
 * @Date : 2018/12/17
 * @Remark : TODO 描述
 */
@FeignClient(value = "WARRIORS-SERVER-ASYNC",fallback = HiHystric.class)
public interface HiService {

    @RequestMapping(value = "task1",method = RequestMethod.GET)
    public String hi();
}
