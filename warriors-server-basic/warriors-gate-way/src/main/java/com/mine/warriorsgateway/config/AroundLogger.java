package com.mine.warriorsgateway.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
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

    /**
     *  环绕通知,环绕增强，相当于MethodInterceptor
     */
    @Around("execution(* com.mine.*.*.*.*(..))")
    public Object arround(ProceedingJoinPoint joinPoint) {
        log.info("[方法环绕]--start...↓");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        log.info("URL : " + request.getRequestURL().toString());
        log.info("HTTP_METHOD : " + request.getMethod());
        log.info("IP : " + request.getRemoteAddr());
        log.info("PORT : " + request.getServerPort());
        log.info("URI : " + request.getRequestURI());
        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
        try {
//            log.info("方法环绕proceed↑，返回结果是 :" + joinPoint.proceed());
            log.info("RETURN :" + joinPoint.proceed());
            log.info("[方法环绕]--end...");
            return joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }
}