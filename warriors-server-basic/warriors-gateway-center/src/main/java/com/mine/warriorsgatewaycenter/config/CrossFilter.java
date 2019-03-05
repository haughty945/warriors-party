package com.mine.warriorsgatewaycenter.config;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @program: warriors-party
 * @description: 跨域过滤器
 * @author: Mine.Lee
 * @create: 2019-01-15 19:52
 * @version: v1.0
 */
@Component
public class CrossFilter implements Filter {

    /**
     * @param filterConfig
     * @return void
     * @throws ..
     * @description 初始化过滤器
     * @remark ..在项目启动时执行
     * @author Mine.Lee
     * @create 2019/1/15 20:07
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @return void
     * @throws IOException
     * @throws ServletException
     * @description 进行过滤处理
     * @remark header中需要传进更多属性请配置Access-Control-Allow-Headers的value
     * @author Mine.Lee
     * @create 2019/1/15 20:07
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization,Content-Type");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    /**
     * @param
     * @return void
     * @throws ..
     * @description 销毁过滤器
     * @remark 项目stop执行
     * @author Mine.Lee
     * @create 2019/1/15 20:09
     */
    @Override
    public void destroy() {

    }
}
