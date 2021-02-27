package com.lemonzuo.service.impl;

import com.lemonzuo.mapper.OrderMapper;
import com.lemonzuo.modle.Order;
import com.lemonzuo.service.AccountService;
import com.lemonzuo.service.OrderService;
import com.lemonzuo.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author LemonZuo
 * @create 2021-02-26 22:19
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private AccountService accountService;
    @Resource
    private StorageService storageService;

    /**
     * 创建订单
     *
     * @param order
     */
    @Override
    @GlobalTransactional(name = "order", rollbackFor = Exception.class)
    public void createOrder(Order order) {
        // 创建订单
        log.info("=====创建订单=====");
        orderMapper.createOrder(order);

        // 扣减库存
        log.info("=====订单服务调用库存，扣减库存=====");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("=====库存减少结束=====");

        // 扣减余额
        log.info("=====订单服务调用账户，扣减余额=====");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("=====扣减余额成功=====");

        // 修改订单状态为成功，status:0 -> 1
        log.info("=====修改订单状态=====");
        orderMapper.update(order.getUserId(), Order.SUCCESS);
        log.info("=====订单状态修改成功=====");

        log.info("=====订单结束=====");
    }
}
