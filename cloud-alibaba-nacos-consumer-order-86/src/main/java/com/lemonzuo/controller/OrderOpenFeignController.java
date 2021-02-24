package com.lemonzuo.controller;

import com.lemonzuo.model.CommonResult;
import com.lemonzuo.model.Payment;
import com.lemonzuo.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author LemonZuo
 * @create 2021-02-24 22:22
 */
@RestController
public class OrderOpenFeignController {
    @Resource
    private PaymentService paymentService;

    @GetMapping("consumer/payment/feign/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        CommonResult<Payment> result = paymentService.getPaymentById(id);
        return result;
    }
}
