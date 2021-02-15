package com.lemonzuo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author LemonZuo
 * @create 2021-02-15 17:18
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SentinelServiceApplication.class, args);
    }
}
