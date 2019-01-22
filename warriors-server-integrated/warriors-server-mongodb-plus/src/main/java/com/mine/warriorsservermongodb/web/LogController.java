package com.mine.warriorsservermongodb.web;

import com.mine.warriorsservermongodb.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: warriors-party
 * @description: 日志记录控制层
 * @author: Mine.Lee
 * @create: 2019-01-22 17:30
 * @version: v1.0
 * @remark: ..
 */
@RestController
@RequestMapping("hello")
public class LogController {


    @Autowired
    private LogService logService;

    @RequestMapping("test1")
    public String insert() {

        return logService.insert();


    }


}
