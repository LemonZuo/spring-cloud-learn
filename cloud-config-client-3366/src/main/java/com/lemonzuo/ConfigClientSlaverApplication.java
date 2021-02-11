package com.lemonzuo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author LemonZuo
 * @create 2021-02-11 11:12
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientSlaverApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientSlaverApplication.class, args);
    }
}
