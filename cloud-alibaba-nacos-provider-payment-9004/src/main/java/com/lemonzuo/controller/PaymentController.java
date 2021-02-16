package com.lemonzuo.controller;

import cn.hutool.core.util.IdUtil;
import com.lemonzuo.model.CommonResult;
import com.lemonzuo.model.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author LemonZuo
 * @create 2021-02-12 21:36
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String server;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();

    static {
        hashMap.put(1L, new Payment(1L, IdUtil.simpleUUID()));
        hashMap.put(2L, new Payment(2L, IdUtil.simpleUUID()));
        hashMap.put(3L, new Payment(3L, IdUtil.simpleUUID()));
        hashMap.put(4L, new Payment(4L, IdUtil.simpleUUID()));
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable Long id) {
        Payment payment = hashMap.get(id);
        CommonResult<Payment> result = new CommonResult<>(200, "From Mysql,serverPort: " + server, payment);
        return result;
    }
}
