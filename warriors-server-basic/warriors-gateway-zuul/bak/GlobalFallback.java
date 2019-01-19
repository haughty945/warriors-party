package com.mine.warriorsgatewayzuul.config;

import com.alibaba.fastjson.JSON;
import com.mine.warriorsservercommon.pojo.ResultVO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @program: warriors-party
 * @description: 服务组件回退配置
 * @author: Mine.Lee
 * @create: 2019-01-16 22:40
 * @version: v1.0
 * @remark: zuul对服务集群进行了反向代理，集成了hystrix，zuul也能实现fallback
 */
@Component
public class GlobalFallback implements ZuulFallbackProvider {

    /**
     * @description 配置需要回退的服务Id :: 如果所有服务路由都支持回退，则return "*"或return null
     * @author Mine.Lee
     * @create 2019/1/16 22:43
     * @return java.lang.String
     */
    @Override
    public String getRoute() {
//        return "warriors-server-aop";
        return "*";
    }

    /**
     * @description 如果请求用户服务失败，配置响应给客户端的内容
     * @author Mine.Lee
     * @create 2019/1/16 22:47
     * @return org.springframework.http.client.ClientHttpResponse
     */
    @Override
    public ClientHttpResponse fallbackResponse() {
//        return null;
        return new ClientHttpResponse() {
            /**
             * @return org.springframework.http.HttpStatus
             * @throws IOException
             * @description 状态码
             * @remark 网关向api服务请求是失败了，但是消费者客户端向网关发起的请求是OK的,不应该把api的404,500等问题抛给客户端网关和api服务集群对于客户端来说是黑盒子
             * @author Mine.Lee
             * @create 2019/1/16 22:58
             */
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.OK.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.OK.getReasonPhrase();
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                ResultVO<Object> ret = new ResultVO<>();
                ret.setCode(404);
                ret.setMsg("XX模块待启动...");
                return new ByteArrayInputStream(JSON.toJSONString(ret).getBytes("UTF-8"));
            }

            /**
             * @return org.springframework.http.HttpHeaders
             * @description body中的内容编码，防止乱码
             * @author Mine.Lee
             * @create 2019/1/16 23:05
             */
            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
                return httpHeaders;
            }
        };
    }
}
