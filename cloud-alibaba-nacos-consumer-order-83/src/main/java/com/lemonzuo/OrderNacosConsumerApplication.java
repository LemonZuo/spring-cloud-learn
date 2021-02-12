package com.lemonzuo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author LemonZuo
 * @create 2021-02-12 21:34
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderNacosConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderNacosConsumerApplication.class, args);
    }
}
