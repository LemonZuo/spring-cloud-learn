package com.lemonzuo.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/hotKey")
    @SentinelResource(value = "hotKey", blockHandler = "dealHotKey")
    public String hotKey(@RequestParam(value = "p1", required = false) String p1,
                         @RequestParam(value = "p1", required = false) String p2) {
        return "====hot key====";
    }

    /**
     * 降级处理方法
     * @param p1
     * @param p2
     * @param exception
     * @return
     */
    public String dealHotKey(String p1, String p2, BlockException exception) {
        return "====dealHotKey====";
    }
}
