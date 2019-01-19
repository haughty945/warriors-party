package com.mine.warriorsserverasync.web;

import com.mine.warriorsserverasync.async.AsyncTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 * @program: warriors-party
 * @description: 测试异步调用
 * @author: Mine.Lee
 * @create: 2019-01-19 17:24
 * @version: v1.0
 * @remark: ..
 */
@RestController
public class AsyncTaskController {

    @Autowired
    private AsyncTask asyncTask;

    @RequestMapping("task1")
    public String doTask() throws InterruptedException {
        long currentTimeMillis = System.currentTimeMillis();
//        Long task1 = asyncTask.task1();
//        Long task2 = asyncTask.task2();
//        Long task3 = asyncTask.task3();
        Future<String> task4 = asyncTask.task4();
        Future<String> task5 = asyncTask.task5();
        Future<String> task6 = asyncTask.task6();
        String result = null;
        while (true) {
            if (task4.isDone() && task5.isDone() && task6.isDone()) {
                // 三个任务都调用完成，退出循环等待
                break;
            }
        }
        long currentTimeMillis1 = System.currentTimeMillis();
        result = "task任务总耗时:" + (currentTimeMillis1 - currentTimeMillis) + "ms";
        return result;
    }
}
