package com.lemonzuo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author LemonZuo
 * @create 2021-02-12 16:55
 */
@EnableEurekaClient
@SpringBootApplication
public class CloudStreamConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudStreamConsumerApplication.class, args);
    }
}
