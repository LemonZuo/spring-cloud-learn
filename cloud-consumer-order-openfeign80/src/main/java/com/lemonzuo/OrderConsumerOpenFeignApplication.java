package com.lemonzuo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author LemonZuo
 * @create 2020-09-17 13:55
 */
@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class OrderConsumerOpenFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsumerOpenFeignApplication.class, args);
    }
}
