package com.mine.warriorsgatewayzuul.config.filter;

import com.alibaba.fastjson.JSON;
import com.mine.warriorsservercommon.utils.ResultVOUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: warriors-party
 * @description: 访问权限过滤器
 * @author: Mine.Lee
 * @create: 2019-01-16 23:45
 * @version: v1.0
 */
@Component
@Slf4j
public class AccessFilter extends ZuulFilter {

    /**
     * @return java.lang.String
     * @description 过滤器类型(String
     * @remark Zuul定义一下四中类型
     * pre：可以在请求被路由之前调用
     * routing：在路由请求时候被调用
     * post：在routing和error过滤器之后被调用
     * error：处理请求发生错误时被调用
     * @author Mine.Lee
     * @create 2019/1/16 23:47
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * @return int
     * @description 过滤器执行级别或者顺序。数字越小，优先级越高
     * @author Mine.Lee
     * @create 2019/1/16 23:49
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * @description 过滤器的开关
     * @remark 生效为true 不生效为false 如果这个请求最终被拦截掉,则后面的过滤器逻辑也不需要执行了
     * @author Mine.Lee
     * @create 2019/1/16 23:50
     * @return boolean
     */
    @Override
    public boolean shouldFilter() {
//        return RequestContext.getCurrentContext().sendZuulResponse();
        return false;
    }

    /**
     * @description 过滤规则
     * @remark ..或者叫做过滤器的具体逻辑的实现
     *          通过请求的上下文对象去设置网关是否对该请求响应处理; requestContext.setSendZuulResponse(true)  false 拦截 true 放行
     * @author Mine.Lee
     * @create 2019/1/16 23:53
     * @return java.lang.Object
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletResponse response = requestContext.getResponse();
        response.setContentType("application/json; charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        HttpServletRequest request = requestContext.getRequest();
        if (StringUtils.isEmpty(request.getHeader("access-token"))) {
            log.warn("access token is empty");
            requestContext.setSendZuulResponse(false);
            try {
                response.getWriter()
                        .write(JSON.toJSONString(ResultVOUtil.returnFail(401, "access-token不存在")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
