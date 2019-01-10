package com.mine.warriorsgateway.filter;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

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
            log.info("REQUEST_URL : " + req.getRequestURL() + "Gateway filtering in progress");
            log.info("REQUEST_HEADER : " + JSON.toJSONString(req.getHeaderNames()));
            log.info("REQUEST_METHOD : " + req.getMethod());
            log.info("REQUEST_IP : " + req.getRemoteAddr());
            log.info("REQUEST_PORT : " + req.getServerPort());
            log.info("REQUEST_URI : " + req.getRequestURI());
            log.info("REQUEST_PARAM : " + JSON.toJSONString(req.getParameterMap()));
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
//        log.info("过滤器destroy...");
    }
}
