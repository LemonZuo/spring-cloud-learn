package com.lemonzuo.service;

import com.lemonzuo.model.CommonResult;
import com.lemonzuo.model.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author LemonZuo
 * @create 2021-02-24 22:18
 */
@Component
@FeignClient(value = "payment-nacos-provider", fallback = PaymentFallBackService.class)
public interface PaymentService {
    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
}
