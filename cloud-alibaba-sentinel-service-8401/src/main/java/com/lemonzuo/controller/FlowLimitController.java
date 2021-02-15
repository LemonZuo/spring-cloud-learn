package com.lemonzuo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LemonZuo
 * @create 2021-02-15 17:19
 */
@RestController
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() {
        return "testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "testB";
    }
}
