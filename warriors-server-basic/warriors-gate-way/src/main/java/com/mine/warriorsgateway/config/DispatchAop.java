//package com.mine.warriorsgateway.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//import springfox.documentation.spring.web.json.Json;
//
//import javax.servlet.http.HttpServletRequest;
//
//@Aspect
////@Component
//@Slf4j
//public class DispatchAop {
//
//    @Pointcut("execution(public * com.mine.warriorsgateway.filter.*.*(..))")
//    public void webPointCut() {
//    }
//
//    @Before("webPointCut()")
//    public void deBefore(JoinPoint joinPoint) {
//        System.out.println("------------------切面before执行");
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        if (attributes != null) {
//            HttpServletRequest request = attributes.getRequest();
//            System.out.println("浏览器输入的URL : " + request.getRequestURL().toString());
//            System.out.println(request.toString());
//            System.out.println("HTTP_METHOD : " + request.getMethod());
//            System.out.println("IP : " + request.getRemoteAddr());
//            System.out.println("执行的业务方法名=CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//        }
//
//    }
//
//    @AfterReturning(returning = "ret", pointcut = "webPointCut()")
//    public void doAfterReturning(Object ret) throws Throwable {
//        System.out.println("切面执行完毕，方法的返回值 : " + ret);
//    }
//
//    @After("webPointCut()")
//    public void after(JoinPoint joinPoint) {
//
//    }
//}
