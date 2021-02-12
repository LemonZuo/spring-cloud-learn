package com.lemonzuo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LemonZuo
 * @create 2021-02-12 21:36
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/get/{id}")
    public String getPaymentById(@PathVariable Long id) {
        StringBuffer result = new StringBuffer("端口号：")
                .append(port)
                .append(" ,id:")
                .append(id);
        return result.toString();
    }
}
