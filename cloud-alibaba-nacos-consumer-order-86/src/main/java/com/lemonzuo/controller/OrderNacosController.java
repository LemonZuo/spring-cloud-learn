package com.lemonzuo.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lemonzuo.model.CommonResult;
import com.lemonzuo.model.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author LemonZuo
 * @create 2021-02-12 22:29
 */
@Slf4j
@RestController
public class OrderNacosController {
    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serviceUrl;

    @GetMapping("consumer/payment/get/{id}")
    @SentinelResource(value = "getPayment", blockHandler = "handle")
    public CommonResult getPayment(@PathVariable(name = "id") Long id) {
        CommonResult result = restTemplate.getForObject(serviceUrl + "/payment/get/" + id, CommonResult.class);
        if (id == 4) {
            throw new IllegalArgumentException("参数非法异常");
        } else if (result.getData() == null) {
            throw new NullPointerException("ID对应记录为空");
        }
        return result;
    }

    public CommonResult fallBack(@PathVariable(name = "id")Long id, Throwable throwable) {
        Payment payment = new Payment(id, null);
        CommonResult result = new CommonResult(444, "fallBack:" + throwable.getMessage(), payment);
        return result;
    }

    public CommonResult handle(@PathVariable(name = "id")Long id, BlockException exception) {
        Payment payment = new Payment(id, null);
        CommonResult result = new CommonResult(444, "handle:" + exception.getMessage(), payment);
        return result;
    }
}
