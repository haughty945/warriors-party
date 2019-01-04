package com.mine.warriorsserveraop.web;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("hello")
public class HelloController {

    @RequestMapping("test1")
    public Object hello1() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("name", "张三");
        return map;
    }

    @RequestMapping("test2")
    public Object hello2() {
        int i = 1 / 0;
        return "success2";
    }

    @RequestMapping("test3")
    public Object hello3() {
        return null;
    }

    @RequestMapping(value = "test4", method = RequestMethod.POST)
    public Object hello4(@RequestBody Map map) {
        List<Map> list = new ArrayList<>();
        list.add(map);
        list.add(map);
        return list;
    }

    @RequestMapping(value = "test5", method = RequestMethod.POST)
    public Object hello5(@RequestParam(value = "name") String name) {
        return "hello " + name;
    }
}
