package com.lemonzuo.service;

import com.lemonzuo.model.CommonResult;
import com.lemonzuo.model.Payment;
import org.springframework.stereotype.Component;

/**
 * @author LemonZuo
 * @create 2021-02-24 22:23
 */
@Component
public class PaymentFallBackService implements PaymentService {
    @Override
    public CommonResult<Payment> getPaymentById(Long id) {
        return new CommonResult<>(444, "服务降级返回,PaymentFallBackService");
    }
}
