package com.mine.warriorsgateway.filter;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

@Component
@Slf4j
public class testFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        log.info("过滤器init。。。");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        if (req.getRequestURI().contains("api")) {
            log.info("请求 : " + req.getRequestURL() + "进入正在执行网关过滤器");
            log.info("HEADER : " + JSON.toJSONString(req.getHeaderNames()));
            log.info("IP : " + req.getRemoteAddr());
            log.info("REQUEST_PORT : " + req.getServerPort());
            log.info("URI : " + req.getRequestURI());
            log.info("PARAM : " + JSON.toJSONString(req.getParameterMap()));
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
//        log.info("过滤器destroy...");
    }
}
