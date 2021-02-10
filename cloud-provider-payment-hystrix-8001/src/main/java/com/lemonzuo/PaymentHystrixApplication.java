package com.lemonzuo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author LemonZuo
 * @create 2020-09-17 21:31
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class PaymentHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixApplication.class, args);
    }
}
