package com.mine.warriorsserveraop.configuration.aop;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.ArrayUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    @Around("pointcut()")
    public Object arround(ProceedingJoinPoint joinPoint) {
        log.info("[···方法环绕···]--start...↓");
        boolean exception = false;
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.info("REQUEST_TIME : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        log.info("REQUEST_URL : " + request.getRequestURL().toString());
        log.info("REQUEST_METHOD : " + request.getMethod());
        log.info("REQUEST_IP : " + request.getRemoteAddr());
        log.info("REQUEST_PORT : " + request.getServerPort());
        log.info("REQUEST_URI : " + request.getRequestURI());
        log.info("REQUEST_ARGS[] : " + JSON.toJSONString(joinPoint.getArgs()));
        log.info("JAVA_CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        try {
//            log.info("方法环绕proceed↑，返回结果是 :" + joinPoint.proceed());
            log.info("RESPONSE_ARGS : " + JSON.toJSONString(joinPoint.proceed()));
            return joinPoint.proceed();
        } catch (Throwable e) {
            exception = true;
            return null;
        } finally {
            log.info("JAVA_CLASS_EXCEPTION : " + exception);
            log.info("[···方法环绕···]--end...↑");
        }
    }

    /**
     *
     * 前置增强
     * @param joinPoint
     * @throws Throwable
     */
//    @Before("pointcut()")
//    public void doBefore(JoinPoint joinPoint) throws Throwable {
//        System.out.println("前置通知start...");
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//        // 记录下请求内容
//        System.out.println("URL : " + request.getRequestURL().toString());
//        System.out.println("HTTP_METHOD : " + request.getMethod());
//        System.out.println("IP : " + request.getRemoteAddr());
//        System.out.println("PORT : " + request.getServerPort());
//        System.out.println("URI : " + request.getRequestURI());
//        System.out.println("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//        System.out.println("ARGS : " + Arrays.toString(joinPoint.getArgs()));
//    }

    /**
     * 处理完请求后置通知
     * @param ret
     * @throws Throwable
     */
//    @AfterReturning(returning = "ret", pointcut = "pointcut()")
//    public void doAfterReturning(Object ret) throws Throwable {
//        System.out.println("处理完请求后置通知==>方法的返回值 : " + ret);
//    }

    /**
     * 后置异常通知
     * @param joinPoint
     */
//    @AfterThrowing("pointcut()")
//    public void throwss(JoinPoint joinPoint) {
//        System.out.println("后置异常通知==>方法异常时执行.....");
//    }

    /**
     * 后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
     * @param joinPoint
     */
//    @After("pointcut()")
//    public void after(JoinPoint joinPoint) {
//        System.out.println("后置最终通知==>方法最后执行.....");
//    }
}
