package com.lemonzuo.service;

import com.lemonzuo.modle.Order;

/**
 * @author LemonZuo
 * @create 2021-02-25 22:47
 */
public interface OrderService {
    /**
     * 创建订单
     * @param order
     */
    void createOrder(Order order);
}
