package com.mine.warriorsserverredis.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisConnectionUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author : https://blog.csdn.net/dannyiscoder/article/details/78458732
 * @Date : 2019/1/13
 * @Remark : 分布式锁
 * 为什么要用lua脚本操作redis数据库?
 * 1.减少开销–减少向redis服务器的请求次数
 * 2.原子操作–redis将lua脚本作为一个原子执行
 * 3.可复用–其他客户端可以使用已经执行过的lua脚本
 * 4.增加redis灵活性–lua脚本可以帮助redis做更多的事情
 * 5.lua脚本本身体积小,启动速度快.
 */
@Component
@Slf4j
public class RedisLockUtil {

    @Value("${server.port}")
    private String port;

    @Autowired
    private RedisTemplate redisTemplate;

    private final Long DEFAULT_EXPIRE_MILLIS = 20000L;

    private final String DEFAULT_KEY_PREFIX = "LOCK : ";

    private final String DEFAULT_VALUE_SUFFIX = " : running:::";

    public Boolean lock(String lockName) {
        return lock(lockName, DEFAULT_EXPIRE_MILLIS);
    }

    /**
     * 获取锁
     *
     * @param lockName
     * @param expireTime
     * @return
     */
    public Boolean lock(String lockName, long expireTime) {
        // 获取连接
        RedisConnectionFactory connectionFactory = redisTemplate.getConnectionFactory();
        RedisConnection redisConnection = connectionFactory.getConnection();
        // 生成key
        String lockKey = DEFAULT_KEY_PREFIX + lockName;
        // 生成value
        String lockValue = lockName + DEFAULT_VALUE_SUFFIX + port;
        // 超时时间，上锁后超过此时间则自动释放
        long lockExpire = expireTime / 1000;

        // 获取锁的超时时间，超过这个时间则放弃获取锁
        long end = System.currentTimeMillis() + expireTime;

        while (System.currentTimeMillis() < end) {
            if (redisConnection.setNX(lockKey.getBytes(), lockValue.getBytes())) {
                redisConnection.expire(lockKey.getBytes(), lockExpire);
                // 关闭连接
                RedisConnectionUtils.releaseConnection(redisConnection, connectionFactory);
                return true;
            }
//             返回-1代表key没有设置超时时间，为key设置一个超时时间
            if (redisConnection.ttl(lockKey.getBytes()) == -1) {
                redisConnection.expire(lockKey.getBytes(), lockExpire);
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                log.warn("获取到分布式锁：线程中断！");
                unLock(lockName);
                Thread.currentThread().interrupt();
            }
        }
        RedisConnectionUtils.releaseConnection(redisConnection, connectionFactory);
        return false;
    }

    /**
     * 释放锁
     *
     * @param lockName 锁
     * @return
     */
    public boolean unLock(String lockName) {
        // 生成key
        String lockKey = DEFAULT_KEY_PREFIX + lockName;
        // 生成value
        String lockValue = lockName + DEFAULT_VALUE_SUFFIX + port;
        // 获取连接
        RedisConnectionFactory connectionFactory = redisTemplate.getConnectionFactory();
        RedisConnection redisConnection = connectionFactory.getConnection();
        boolean releaseFlag = false;
        while (true) {
            try {
                // 监视lock，准备开始事务
                redisConnection.watch(lockKey.getBytes());
                //通过前面返回的value值判断是不是该锁，若是该锁，则删除，释放锁
                byte[] valueBytes = redisConnection.get(lockKey.getBytes());
                if (valueBytes == null) {
                    redisConnection.unwatch();
                    releaseFlag = false;
                    break;
                }
                String identifierValue = new String(valueBytes);
                if (lockValue.equals(identifierValue)) {
                    redisConnection.multi();
                    redisConnection.del(lockKey.getBytes());
                    List<Object> results = redisConnection.exec();
                    if (results == null) {
                        continue;
                    }
                    releaseFlag = true;
                }
                redisConnection.unwatch();
                break;
            } catch (Exception e) {
                log.warn("释放锁异常", e);
                e.printStackTrace();
            }
        }
        RedisConnectionUtils.releaseConnection(redisConnection, connectionFactory);
        return releaseFlag;
    }
}
