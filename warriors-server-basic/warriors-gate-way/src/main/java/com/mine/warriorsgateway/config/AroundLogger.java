package com.mine.warriorsgateway.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author Mr
 * 环绕增强处理
 * 注解方式的就是一个普通类
 */
@Aspect
@Slf4j
@Component
public class AroundLogger {

    //注解方式的环绕增强处理
    @Around("execution(* com.mine.warriorsgateway.filter.*.*(..))")
    public Object aroundLogger(ProceedingJoinPoint jp) {
        System.out.println(jp);
        log.info("a调用" + jp.getTarget() + "的" + jp.getSignature().getName() + "方法，方法参数是："
                + Arrays.toString(jp.getArgs()));
        try {
            Object result = jp.proceed();//调用目标方法，获取目标方法的返回值
            log.info("a调用" + jp.getTarget() + "的" + jp.getSignature().getName() + "方法，方法返回值是："
                    + result);
            return result;
        } catch (Exception e) {
            log.error(jp.getSignature().getName() + "方法抛出异常" + e);
            e.printStackTrace();
        } catch (Throwable e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}