package com.lemonzuo.controller;

import com.lemonzuo.model.CommonResult;
import com.lemonzuo.model.Payment;
import com.lemonzuo.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LemonZuo
 * @create 2020-09-09 14:40
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/zk")
    public String info() {
        return "zk--port:"+ port;
    }
}
