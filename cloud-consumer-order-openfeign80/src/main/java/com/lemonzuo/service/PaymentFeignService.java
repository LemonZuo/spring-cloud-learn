package com.lemonzuo.service;

import com.lemonzuo.model.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author LemonZuo
 * @create 2020-09-17 13:57
 */
@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping("/payment/feignGet/{id}")
    CommonResult getPaymentById(@PathVariable("id") Long id);
}
