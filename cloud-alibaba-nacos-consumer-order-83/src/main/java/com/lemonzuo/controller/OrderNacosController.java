package com.lemonzuo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author LemonZuo
 * @create 2021-02-12 22:29
 */
@Slf4j
@RestController
public class OrderNacosController {
    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serviceUrl;

    @GetMapping("consumer/payment/get/{id}")
    public String echo(@PathVariable(name = "id") String id) {
        String result = restTemplate.getForObject(serviceUrl + "/payment/get/" + id, String.class);
        return result;
    }
}
