package com.lemonzuo.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author LemonZuo
 * @create 2021-02-10 23:06
 * GateWay网关全局过滤器
 */
@Configuration
@Slf4j
public class MyLogGateWayFilter implements GlobalFilter, Ordered {
    /**
     * 过滤逻辑
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("=====MyLogGateWayFilter=====");
        ServerHttpRequest request = exchange.getRequest();
        String userName = request.getQueryParams().getFirst("userName");
        if (null == userName) {
            log.info("用户名为空");
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return response.setComplete();
        }
        return chain.filter(exchange);
    }

    /**
     * 加载过滤器顺序
     *
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
