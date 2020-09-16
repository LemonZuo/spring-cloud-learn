package com.lemonzuo.controller;

import com.lemonzuo.model.CommonResult;
import com.lemonzuo.model.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    private static final String PAYMENT_URL = "http://cloud-payment-service";
    @Resource
    private RestTemplate template;

    @GetMapping("/consumer/payment/zk")
    public String info() {
        return template.getForObject(PAYMENT_URL + "/payment/zk", String.class);
    }
}
