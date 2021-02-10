package com.lemonzuo.controller;

import com.lemonzuo.service.OrderFeignHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LemonZuo
 * @create 2020-09-17 22:02
 */
@RestController
public class OrderFeignHystrixController {
    @Autowired
    private OrderFeignHystrixService orderFeignHystrixService;

    @GetMapping("/consume/hystrix/hystrixOk/{id}")
    public String hystrixOk(@PathVariable("id") Long id) {
        return orderFeignHystrixService.hystrixOk(id);
    }

    @GetMapping("/consume/hystrix/hystrixTimeout/{id}")
    @HystrixCommand(fallbackMethod = "hystrixTimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    public String hystrixTimeout(@PathVariable("id") Long id) {
        return orderFeignHystrixService.hystrixTimeout(id);
    }

    String hystrixTimeoutHandler(@PathVariable("id") Long id) {
        return "80-hystrix:服务提供方暂时不可用";
    }
}
