package com.lemonzuo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author LemonZuo
 * @create 2020-08-02 12:24
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentSlaveApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentSlaveApplication.class, args);
    }
}
