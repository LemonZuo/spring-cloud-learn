package com.lemonzuo.controller;

import com.lemonzuo.service.PaymentHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LemonZuo
 * @create 2020-09-17 21:38
 */
@RestController
public class PaymentHystrixController {
    @Autowired
    private PaymentHystrixService paymentHystrixService;

    /*====服务降级====*/

    @GetMapping("/provide/hystrix/hystrixOk/{id}")
    public String hystrixOk(@PathVariable("id") Long id) {
        return paymentHystrixService.hystrixOk(id);
    }

    @GetMapping("/provide/hystrix/hystrixTimeout/{id}")
    public String hystrixTimeout(@PathVariable("id") Long id) {
        return paymentHystrixService.hystrixTimeout(id);
    }

    /*====服务熔断====*/

    @GetMapping("/provide/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Long id) {
        String result = paymentHystrixService.paymentCircuitBreaker(id);
        return result;
    }
}
