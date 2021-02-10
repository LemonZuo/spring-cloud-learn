package com.lemonzuo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author LemonZuo
 * @create 2020-09-17 21:56
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE-HYSTRIX", fallback = OrderFeignHystrixClientService.class)
public interface OrderFeignHystrixService {

    @GetMapping("/provide/hystrix/hystrixOk/{id}")
    String hystrixOk(@PathVariable("id") Long id);

    @GetMapping("/provide/hystrix/hystrixTimeout/{id}")
    String hystrixTimeout(@PathVariable("id") Long id);
}
