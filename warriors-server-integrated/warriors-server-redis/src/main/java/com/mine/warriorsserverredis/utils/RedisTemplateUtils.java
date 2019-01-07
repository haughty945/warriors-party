package com.mine.warriorsserverredis.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * redis 工具
 */
@Slf4j
@Component
public class RedisTemplateUtils {

    /**
     * redisTemplate 操作Object
     */
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * stringRedisTemplate是操作字符串
     */
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 获取redis键值-object
     *
     * @param key
     * @return
     */
    public Object getValueForKey(String key) {
        if (this.redisTemplate != null) {
            return redisTemplate.opsForValue().get(key);
        }
        log.info("查无数据==>获取redis实例失败");
        return null;
    }

    public Object setValueForKey(Object key, Object value) {
        if (redisTemplate != null) {
            redisTemplate.opsForValue().set(key, value);
        }
        log.info("获取redis实例失败");
        return null;
    }


}
