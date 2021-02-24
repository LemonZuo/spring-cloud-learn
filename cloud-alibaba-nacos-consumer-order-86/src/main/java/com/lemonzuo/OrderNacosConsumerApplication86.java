package com.lemonzuo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author LemonZuo
 * @create 2021-02-12 21:34
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderNacosConsumerApplication86 {
    public static void main(String[] args) {
        SpringApplication.run(OrderNacosConsumerApplication86.class, args);
    }
}
