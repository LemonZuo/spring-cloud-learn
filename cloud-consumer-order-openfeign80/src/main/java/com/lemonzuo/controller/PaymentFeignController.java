package com.lemonzuo.controller;

import com.lemonzuo.model.CommonResult;
import com.lemonzuo.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author LemonZuo
 * @create 2020-09-17 14:03
 */
@RestController
public class PaymentFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consume/feign/get/{id}")
    public CommonResult feignGet(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }
}
