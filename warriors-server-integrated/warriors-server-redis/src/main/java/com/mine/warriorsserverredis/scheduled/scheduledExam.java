package com.mine.warriorsserverredis.scheduled;

import com.mine.warriorsserverredis.utils.RedisLockUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author : john_lee
 * @Date : 2019/1/13
 * @Remark : TODO 描述
 * <p>
 * 定时任务做集群多个节点会同时执行,所以要在定时任务开始之前加上下面一行代码
 * if (!this.redisLockUtil.lock("定时任务名字")) return;
 */
@Component
@Slf4j
public class scheduledExam {

    @Value("${server.port}")
    private String port;

    @Autowired
    private RedisLockUtil redisLockUtil;

    @Scheduled(cron = "0/10 * * * * ? ")
    public void logOutTime() throws Exception {
        Method[] methods = MethodUtils.class.getMethods();
        if (!this.redisLockUtil.lock("LOGOUTTIME")) {
            return;
        }
        try {
            Thread.sleep(2000);
            log.info("端口 " + port + "触发定时任务..." + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        } finally {
            this.redisLockUtil.unLock("LOGOUTTIME");
        }
    }
}
