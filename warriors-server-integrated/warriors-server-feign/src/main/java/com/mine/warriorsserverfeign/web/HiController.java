package com.mine.warriorsserverfeign.web;

import com.mine.warriorsserverfeign.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : john_lee
 * @Date : 2018/12/17
 * @Remark : TODO 描述
 */
@RestController
public class HiController {

    @Autowired
    private HiService hiService;

    @RequestMapping("hi")
    public String hi() {
        return hiService.hi();
    }
}
