package com.mine.warriorsserveraop.configuration.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(* com.mine.warriorsserveraop.web.*.*(..))")
    public void pointcut() {
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

    /**
     *  环绕通知,环绕增强，相当于MethodInterceptor
     */
    @Around("pointcut()")
    public Object arround(ProceedingJoinPoint joinPoint) {
        System.out.println("方法环绕start.....↓");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        System.out.println("URL : " + request.getRequestURL().toString());
        System.out.println("HTTP_METHOD : " + request.getMethod());
        System.out.println("IP : " + request.getRemoteAddr());
        System.out.println("PORT : " + request.getServerPort());
        System.out.println("URI : " + request.getRequestURI());
        System.out.println("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        System.out.println("ARGS : " + Arrays.toString(joinPoint.getArgs()));
        try {
            System.out.println("方法环绕proceed↑，返回结果是 :" + joinPoint.proceed());
            return joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }
}
