package com.mine.warriorsfeigndemo.service.Impl;

import com.mine.warriorsfeigndemo.service.HiService;
import org.springframework.stereotype.Component;

/**
 * @Author : john_lee
 * @Date : 2018/12/18
 * @Remark : TODO 描述
 */
@Component
public class HiHystric implements HiService {
    @Override
    public String hi() {
        return "目标服务宕机";
    }
}
