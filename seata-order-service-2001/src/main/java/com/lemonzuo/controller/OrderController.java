package com.lemonzuo.controller;

import com.lemonzuo.model.CommonResult;
import com.lemonzuo.modle.Order;
import com.lemonzuo.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author LemonZuo
 * @create 2021-02-25 22:48
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.createOrder(order);
        CommonResult<Object> result = new CommonResult<>(200, "订单创建成功");
        return result;
    }
}
