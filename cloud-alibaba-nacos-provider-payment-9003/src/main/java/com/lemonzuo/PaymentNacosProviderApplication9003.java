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
public class PaymentNacosProviderApplication9003 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentNacosProviderApplication9003.class, args);
    }
}
