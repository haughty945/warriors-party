package com.mine.warriorsservercommon.config.aop;

import com.alibaba.fastjson.JSON;
import com.mine.warriorsservercommon.entity.LogServlet;
import com.mine.warriorsservercommon.service.ILogServletRepository;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ILogServletRepository iLogServletRepository;

    @Pointcut("execution(* com.mine.*.web.*Controller.*(..))")
    public void pointcut() {
    }

    /**
     * 环绕通知,环绕增强，相当于MethodInterceptor
     */
//    @Around("pointcut()")
//    public Object arround(ProceedingJoinPoint joinPoint) throws Throwable {
//        log.info("[···方法环绕···]--start...↓");
//        boolean exception = false;
//        String JsonRet = "void";
//        GlobalReturn ret = new GlobalReturn();
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
//        log.info("COOKIE1_VALUE : " + request.getCookies()[0].getValue());
        log.info("REQUEST_URL : " + request.getRequestURL().toString());
        log.info("REQUEST_METHOD : " + request.getMethod());
        log.info("REQUEST_IP : " + request.getRemoteAddr());
        log.info("REQUEST_PORT : " + request.getServerPort());
        log.info("REQUEST_URI : " + request.getRequestURI());
        log.info("REQUEST_ARGS[] : " + JSON.toJSONString(joinPoint.getArgs()));
        log.info("JAVA_CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        LogServlet logServlet = new LogServlet();
        logServlet.setCookieValue(request.getCookies()[0].getValue());
        logServlet.setRequestMethod(request.getMethod());
        logServlet.setRequestIp(request.getRemoteAddr());
        logServlet.setRequestPort(request.getServerPort());
        logServlet.setRequestUri(request.getRequestURI());
        logServlet.setJavaClassMethod(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logServlet.setRequestArgs(JSON.toJSONString(joinPoint.getArgs()));
        iLogServletRepository.insertLogServlet(logServlet);
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
        LogServlet logServlet = new LogServlet();
        logServlet.setCookieValue(request.getCookies()[0].getValue());
        LogServlet retLogServlet = iLogServletRepository.selectLogServlet(logServlet);
        BeanUtils.copyProperties(retLogServlet,logServlet);
        logServlet.setResponseArg(JsonRet);
        iLogServletRepository.updateLogServlet(logServlet);
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
        System.out.println("异常通知start...");
//        log.info("COOKIE1_VALUE : " + request.getCookies()[0].getValue().toString());
        LogServlet logServlet = new LogServlet();
        logServlet.setCookieValue(request.getCookies()[0].getValue());
        LogServlet retLogServlet = iLogServletRepository.selectLogServlet(logServlet);
        BeanUtils.copyProperties(retLogServlet,logServlet);
        logServlet.setExceptionFlag(1);
        iLogServletRepository.updateLogServlet(logServlet);
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
