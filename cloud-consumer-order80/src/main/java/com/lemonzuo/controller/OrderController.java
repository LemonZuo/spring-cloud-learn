package com.lemonzuo.controller;

import com.lemonzuo.model.CommonResult;
import com.lemonzuo.model.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author LemonZuo
 * @create 2020-09-16 11:30
 */
@RestController
@Slf4j
public class OrderController {
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate template;

    @GetMapping("/consumer/payment/create")
    public CommonResult create(Payment payment) {
        CommonResult result = template.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
        return result;
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable Long id, CommonResult commonResult) {
        CommonResult result = template.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        return result;
    }

    @GetMapping("consumer/payment/zipkin")
    public String paymentZipkin() {
        String result = template.getForObject(PAYMENT_URL + "/payment/zipkin", String.class);
        return result;
    }
}
