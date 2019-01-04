package com.mine.warriorsserveraop.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {

    @RequestMapping("test1")
    public Object hello1() {
        return "success";
    }

    @RequestMapping("test2")
    public Object hello2() {
        int i = 1 / 0;
        return "success2";
    }

}
