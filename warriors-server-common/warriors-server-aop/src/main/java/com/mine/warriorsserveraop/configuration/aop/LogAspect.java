package com.mine.warriorsserveraop.configuration.aop;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Slf4j
public class LogAspect {

    @Pointcut("execution(* com.mine.warriorsserveraop.web.*.*(..))")
    public void pointcut() {
    }

    /**
     * 环绕通知,环绕增强，相当于MethodInterceptor
     */
//    @Around("pointcut()")
//    public Object arround(ProceedingJoinPoint joinPoint) throws Throwable {
//        log.info("[···方法环绕···]--start...↓");
//        boolean exception = false;
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//        log.info("REQUEST_URL : " + request.getRequestURL().toString());
//        log.info("REQUEST_METHOD : " + request.getMethod());
//        log.info("REQUEST_IP : " + request.getRemoteAddr());
//        log.info("REQUEST_PORT : " + request.getServerPort());
//        log.info("REQUEST_URI : " + request.getRequestURI());
//        log.info("REQUEST_ARGS[] : " + JSON.toJSONString(joinPoint.getArgs()));
//        log.info("JAVA_CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//        try {
//            log.info("RESPONSE_ARGS : " + JSON.toJSONString(joinPoint.proceed()));
//            return joinPoint.proceed();
//        } catch (Throwable e) {
//            e.printStackTrace();
//            exception = true;
//            return null;
//        } finally {
//            log.info("JAVA_CLASS_EXCEPTION : " + exception);
//            log.info("[···方法环绕···]--end...↑");
//        }
//    }

    /**
     * 前置通知
     *
     * @param joinPoint
     * @throws Throwable
     */
    @Before("pointcut()")
    public void doBefore(JoinPoint joinPoint) {
//        System.out.println("前置通知start...");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
//        log.info("COOKIE1_VALUE : " + request.getCookies()[0].getValue().toString());
        log.info("REQUEST_URL : " + request.getRequestURL().toString());
        log.info("REQUEST_METHOD : " + request.getMethod());
        log.info("REQUEST_IP : " + request.getRemoteAddr());
        log.info("REQUEST_PORT : " + request.getServerPort());
        log.info("REQUEST_URI : " + request.getRequestURI());
        log.info("REQUEST_ARGS[] : " + JSON.toJSONString(joinPoint.getArgs()));
        log.info("JAVA_CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    }

    /**
     * 处理完请求后置通知
     *
     * @param ret
     * @throws Throwable
     */
    @AfterReturning(returning = "ret", pointcut = "pointcut()")
    public void doAfterReturning(JoinPoint joinPoint, Object ret) {
//        System.out.println("后置通知start...");
        String JsonRet = "void";
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        if (!ObjectUtils.isEmpty(ret)) JsonRet = JSON.toJSONString(ret);
//        log.info("COOKIE1_VALUE : " + request.getCookies()[0].getValue().toString());
        log.info("RESPONSE_ARG : " + JsonRet);
    }

    /**
     * 后置异常通知
     *
     * @param joinPoint
     */
    @AfterThrowing("pointcut()")
    public void throwss(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.info(request.getRequestURI() + "接口出现");
//        System.out.println("异常通知start...");
//        log.info("COOKIE1_VALUE : " + request.getCookies()[0].getValue().toString());
    }

    /**
     * 后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
     *
     * @param joinPoint
     */
//    @After("pointcut()")
//    public void after(JoinPoint joinPoint) throws InterruptedException {
//        System.out.println("后置最终通知执行");
//    }
}
