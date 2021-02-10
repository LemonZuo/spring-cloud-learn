package com.lemonzuo.service;

import org.springframework.stereotype.Component;

/**
 * @author LemonZuo
 * @create 2021-02-10 15:31
 * openfeign服务降级处理类
 */
@Component
public class OrderFeignHystrixClientService implements OrderFeignHystrixService {
    @Override
    public String hystrixOk(Long id) {
        String result = "80-hystrix-feign(hystrixOk):服务提供方暂时不可用";
        return result;
    }

    @Override
    public String hystrixTimeout(Long id) {
        String result = "80-hystrix-feign(hystrixTimeout):服务提供方暂时不可用";
        return result;
    }
}
