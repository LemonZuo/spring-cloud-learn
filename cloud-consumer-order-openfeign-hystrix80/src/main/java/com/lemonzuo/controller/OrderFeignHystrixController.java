package com.lemonzuo.controller;

import com.lemonzuo.service.OrderFeignHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LemonZuo
 * @create 2020-09-17 22:02
 */
@RestController
@DefaultProperties(defaultFallback = "defaultHandler")
public class OrderFeignHystrixController {
    @Autowired
    private OrderFeignHystrixService orderFeignHystrixService;

    @GetMapping("/consume/hystrix/hystrixOk/{id}")
    public String hystrixOk(@PathVariable("id") Long id) {
        return orderFeignHystrixService.hystrixOk(id);
    }

    @GetMapping("/consume/hystrix/hystrixTimeout/{id}")
    @HystrixCommand
    public String hystrixTimeout(@PathVariable("id") Long id) {
        return orderFeignHystrixService.hystrixTimeout(id);
    }

    /**
     * HystrixCommand针对性处理方案
     * @param id
     * @return
     */
    private String hystrixTimeoutHandler(@PathVariable("id") Long id) {
        return "80-hystrix:服务提供方暂时不可用";
    }

    /**
     * 全局处理方案
     * @return
     */
    private String defaultHandler() {
        String result = "服务器异常请稍后再试！！！";
        return result;
    }
}
