package com.lemonzuo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author LemonZuo
 * @create 2020-08-02 12:24
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentZookeeperApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentZookeeperApplication.class, args);
    }
}
