package com.lemonzuo.controller;

import cn.hutool.core.thread.ThreadUtil;
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

    @GetMapping("/provide/hystrix/hystrixOk/{id}")
    public String hystrixOk(@PathVariable("id") Long id) {
        return paymentHystrixService.hystrixOk(id);
    }

    @GetMapping("/provide/hystrix/hystrixTimeout/{id}")
    public String hystrixTimeout(@PathVariable("id") Long id) {
        return paymentHystrixService.hystrixTimeout(id);
    }
}
