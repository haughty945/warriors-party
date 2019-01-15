package com.mine.warriorsservercommon.config.aop;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @program: warriors-party
 * @description: 记录日志Aspect
 * @author: Mine.Lee
 * @create: 2019-01-15 19:52
 * @version: v1.0
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    /**
     * @param
     * @return void
     * @description 定义切入点
     * @remark 配置切面表达式 ( *为通配符:[0]返回值 [1]层级包 [2]web包下的所有类 [3] 所有方法 后边括号的俩点为任意参数类型,任意参数个数)
     * @author Mine.Lee
     * @create 2019/1/15 19:34
     */
    @Pointcut("execution(* com.mine.*.web.*.*(..))")
    public void pointcut() {
    }

    /**
     * @param joinPoint
     * @return void
     * @throws ..
     * @description 前置通知
     * @remark 处理实际请求前触发,在Attribute中设置一个logId取值UUID,后续响应和异常时候以此判断同一请求做log持久化
     * @author Mine.Lee
     * @create 2019/1/15 19:35
     */
    @Before("pointcut()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("before通知:::触发");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        request.setAttribute("logId", UUID.randomUUID().toString());
//        log.info("LOG_ID : " + request.getAttribute("logId"));
        log.info("REQUEST_URL : " + request.getRequestURL());
        log.info("REQUEST_HEADER : " + JSON.toJSONString(request.getHeaderNames()));
        log.info("REQUEST_METHOD : " + request.getMethod());
        log.info("REQUEST_IP : " + request.getRemoteAddr());
        log.info("REQUEST_PORT : " + request.getServerPort());
        log.info("REQUEST_URI : " + request.getRequestURI());
        log.info("REQUEST_ARGS[] : " + JSON.toJSONString(joinPoint.getArgs()));
        log.info("JAVA_CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    }

    /**
     * @param joinPoint
     * @param ret
     * @return void
     * @description 后置通知
     * @remark 处理完请求后触发
     * @author Mine.Lee
     * @create 2019/1/15 19:36
     */
    @AfterReturning(returning = "ret", pointcut = "pointcut()")
    public void doAfterReturning(JoinPoint joinPoint, Object ret) {
        System.out.println("after通知:::触发");
        String jsonRet = "void";
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = attributes.getResponse();
        HttpServletRequest request = attributes.getRequest();
//        log.info("LOG_ID : " + request.getAttribute("logId"));
        if (!ObjectUtils.isEmpty(ret)) jsonRet = JSON.toJSONString(ret);
        log.info("RESPONSE_ARG : " + jsonRet);
        log.info("RESPONSE_CODE:" + response.getStatus());
    }

    /**
     * @param joinPoint
     * @return void
     * @throws ..
     * @description 异常通知
     * @remark 业务处理发生异常时触发
     * @author Mine.Lee
     * @create 2019/1/15 19:39
     */
    @AfterThrowing("pointcut()")
    public void throwss(JoinPoint joinPoint) {
        System.out.println("exception通知:::触发");
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//        log.info("LOG_ID : " + request.getAttribute("logId"));
    }

    /**
     * @param joinPoint
     * @return void
     * @throws ..
     * @description 最终通知
     * @remark 后置最终通知, final增强，不管是抛出异常或者正常退出都会触发
     * @author Mine.Lee
     * @create 2019/1/15 19:40
     */
    @After("pointcut()")
    public void after(JoinPoint joinPoint) {
        System.out.println("final通知:::触发");
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//        log.info("LOG_ID : " + request.getAttribute("logId"));
    }

//    /**
//     * @param joinPoint
//     * @return java.lang.Object
//     * @throws Throwable
//     * @description 环绕通知
//     * @remark 环绕增强，相当于MethodInterceptor
//     * @author Mine.Lee
//     * @create 2019/1/15 19:33
//     */
//    @Around("pointcut()")
//    public Object arround(ProceedingJoinPoint joinPoint) throws Throwable {
//        log.info("[···方法环绕···]--start...↓");
//        boolean exception = false;
//        String JsonRet = "void";
//        ResultVO ret = new ResultVO();
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
//            if (joinPoint.proceed() != null) {
//                JsonRet = JSON.toJSONString(joinPoint.proceed());
//            }
//            log.info("RESPONSE_ARG : " + JsonRet);
//            return joinPoint.proceed();
//        } catch (Throwable e) {
//            ret.setErrcode(500);
//            ret.setErrmsg("服务器内部异常");
//            e.printStackTrace();
//            exception = true;
//            return ret;
//        } finally {
//            log.info("JAVA_CLASS_EXCEPTION : " + exception);
//            log.info("[···方法环绕···]--end...↑");
//        }
//    }

}
