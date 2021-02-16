package com.lemonzuo.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lemonzuo.handle.CustomerBlockHandler;
import com.lemonzuo.model.CommonResult;
import com.lemonzuo.model.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LemonZuo
 * @create 2021-02-16 13:21
 */
@RestController
public class RateLimitController {
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource() {
        CommonResult result = new CommonResult(200, "按资源名称限流测试", new Payment(2021L, "SERIAL001"));
        return result;
    }

    public CommonResult handleException(BlockException exception) {
        CommonResult result = new CommonResult(444, exception.getClass().getCanonicalName(), "服务不可用");
        return result;
    }

    @GetMapping("/byUrl")
    public CommonResult byUrl() {
        CommonResult result = new CommonResult(200, "按URL限流测试", new Payment(2021L, "SERIAL002"));
        return result;
    }

    @GetMapping("/masterCustomerHandle")
    @SentinelResource(value = "masterCustomerHandle",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "masterHandleException")
    public CommonResult customerHandle() {
        CommonResult result = new CommonResult(200, "用户自定义", new Payment(2021L, "SERIAL003"));
        return result;
    }

    @GetMapping("/slaverCustomerHandle")
    @SentinelResource(value = "slaverCustomerHandle",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "slaverHandleException")
    public CommonResult slaverHandle() {
        CommonResult result = new CommonResult(200, "用户自定义", new Payment(2021L, "SERIAL004"));
        return result;
    }
}
