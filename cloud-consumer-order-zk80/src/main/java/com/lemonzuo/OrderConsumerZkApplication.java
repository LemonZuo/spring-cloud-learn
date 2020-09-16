package com.lemonzuo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author LemonZuo
 * @create 2020-09-16 11:26
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsumerZkApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsumerZkApplication.class, args);
    }
}
