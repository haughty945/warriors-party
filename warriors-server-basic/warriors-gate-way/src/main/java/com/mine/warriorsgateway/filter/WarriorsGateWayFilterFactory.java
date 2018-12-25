package com.mine.warriorsgateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;

/**
 * @Author : john_lee
 * @Date : 2018/12/25
 * @Remark : TODO 描述
 */
@Configurable
@Slf4j
public class WarriorsGateWayFilterFactory extends AbstractGatewayFilterFactory<WarriorsGateWayFilterFactory.Config> {

    @Override
    public GatewayFilter apply(Config config) {
        return null;
    }

    public static class Config {

    }
}
