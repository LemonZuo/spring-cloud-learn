package com.lemonzuo.controller;

import com.lemonzuo.model.CommonResult;
import com.lemonzuo.model.Payment;
import com.lemonzuo.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author LemonZuo
 * @create 2020-09-09 14:40
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String port;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment, CommonResult commonResult) {

        int result = paymentService.create(payment);
        log.info("****插入结果:{}", result);
        if (result > 0) {
            commonResult = new CommonResult(200, "插入数据库成功", result);
        } else {
            commonResult = new CommonResult(444, "插入数据库失败");
        }
        return commonResult;

    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable Long id, CommonResult commonResult) {
        Payment result = paymentService.getPaymentById(id);
        if (result != null) {
            commonResult.setCode(200);
            commonResult.setMessage(port+":查询成功");
            commonResult.setData(result);
        } else {
            commonResult.setCode(444);
            commonResult.setMessage("没有对应记录");
        }
        return commonResult;
    }

    @GetMapping("/payment/feignGet/{id}")
    public CommonResult feignGetPaymentById(@PathVariable Long id, CommonResult commonResult) {
        Payment result = paymentService.getPaymentById(id);
        if (result != null) {
            commonResult.setCode(200);
            commonResult.setMessage("feign" + port+":查询成功");
            commonResult.setData(result);
        } else {
            commonResult.setCode(444);
            commonResult.setMessage("没有对应记录");
        }
        return commonResult;
    }
}
