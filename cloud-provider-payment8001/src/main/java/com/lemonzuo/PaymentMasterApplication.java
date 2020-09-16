package com.lemonzuo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author LemonZuo
 * @create 2020-08-02 12:24
 */
@SpringBootApplication
// eureka
//@EnableEurekaClient
@EnableDiscoveryClient
public class PaymentMasterApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMasterApplication.class, args);
    }
}
