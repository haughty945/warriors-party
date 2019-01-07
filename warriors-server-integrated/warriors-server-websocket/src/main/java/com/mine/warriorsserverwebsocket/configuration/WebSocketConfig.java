package com.mine.warriorsserverwebsocket.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * @EnableWebSocketMessageBroker    表示开启使用STOMP协议来传输基于代理的消息，Broker就是代理的意思。
 * registerStompEndpoints方法表示注册STOMP协议的节点，并指定映射的URL
 * addEndpoint(“/mine”).withSockJS(); 用来注册STOMP协议节点，同时指定使用SockJS
 * configureMessageBroker方法用来配置消息代理，由于我们是实现推送功能，这里的消息代理是/topic
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {

        //注册一个Stomp 协议的endpoint,并指定 SockJS协议
        registry.addEndpoint("/endpointWisely")
                .setAllowedOrigins("*")     // 解决跨域问题
                .withSockJS();

        //注册一个名字为"endpointChat" 的endpoint,并指定 SockJS协议。   点对点-用
        registry.addEndpoint("/endpointChat")
                .setAllowedOrigins("*")
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {

        //广播式应配置一个/topic 消息代理
        registry.enableSimpleBroker("/topic");

        //点对点式增加一个/queue 消息代理
        registry.enableSimpleBroker("/queue", "/topic");
    }
}
