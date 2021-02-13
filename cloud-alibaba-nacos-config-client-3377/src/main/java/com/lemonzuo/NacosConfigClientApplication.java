package com.lemonzuo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author LemonZuo
 * @create 2021-02-13 16:56
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfigClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigClientApplication.class, args);
    }
}
