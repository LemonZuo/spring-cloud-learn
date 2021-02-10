package com.lemonzuo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author LemonZuo
 * @create 2020-09-17 21:48
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
public class OrderFeignHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignHystrixApplication.class, args);
    }
}
