package com.lemonzuo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author LemonZuo
 * @create 2020-09-16 14:34
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServeSlaveApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServeSlaveApplication.class, args);
    }
}
