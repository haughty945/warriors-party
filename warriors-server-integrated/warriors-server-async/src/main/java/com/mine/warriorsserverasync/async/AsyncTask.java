package com.mine.warriorsserverasync.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @program: warriors-party
 * @description: 测试异步调用实现
 * @author: Mine.Lee
 * @create: 2019-01-19 17:24
 * @version: v1.0
 * @remark: ..
 */
@Component
public class AsyncTask {

    @Async
    public Long task1() throws InterruptedException {
        long currentTimeMillis = System.currentTimeMillis();
        Thread.sleep(1000);
        long currentTimeMillis1 = System.currentTimeMillis();
        System.out.println("task1任务耗时:"+(currentTimeMillis1-currentTimeMillis)+"ms");
        return currentTimeMillis1 - currentTimeMillis;
    }

    @Async
    public Long task2() throws InterruptedException {
        long currentTimeMillis = System.currentTimeMillis();
        Thread.sleep(2000);
        long currentTimeMillis1 = System.currentTimeMillis();
        System.out.println("task2任务耗时:"+(currentTimeMillis1-currentTimeMillis)+"ms");
        return currentTimeMillis1 - currentTimeMillis;
    }

    @Async
    public Long task3() throws InterruptedException {
        long currentTimeMillis = System.currentTimeMillis();
        Thread.sleep(3000);
        long currentTimeMillis1 = System.currentTimeMillis();
        System.out.println("task3任务耗时:"+(currentTimeMillis1-currentTimeMillis)+"ms");
        return currentTimeMillis1 - currentTimeMillis;
    }

    /**
     * 想要知道三个异步任务什么时候执行完，执行的结果怎样呢？可以采用添加Fature回调方式判断
     */
    @Async
    public Future<String> task4() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(400);
        long end = System.currentTimeMillis();
        System.out.println("task4任务耗时:"+(end-start)+"ms");
        return new AsyncResult<String>("task4任务执行完毕");
    }

    @Async
    public Future<String> task5() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(500);
        long end = System.currentTimeMillis();
        System.out.println("task5任务耗时:"+(end-start)+"ms");
        return new AsyncResult<String>("task5任务执行完毕");
    }

    @Async
    public Future<String> task6() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(600);
        long end = System.currentTimeMillis();
        System.out.println("task6任务耗时:" + (end - start) + "ms");
        return new AsyncResult<String>("task6任务执行完毕");
    }


}
