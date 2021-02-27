package com.lemonzuo.mapper;

import com.lemonzuo.modle.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author LemonZuo
 * @create 2021-02-25 22:47
 */
@Mapper
public interface OrderMapper {
    /**
     * 创建订单
     * @param order
     */
    void createOrder(Order order);

    void update(@Param("userId") String userId,
                @Param("status") Integer status);
}
