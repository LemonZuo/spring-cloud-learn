package com.lemonzuo.modle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LemonZuo
 * @create 2021-02-25 22:21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    public final static Integer SUCCESS = 1;
    private Integer id;
    private String userId;
    private String productId;
    private Integer count;
    private Integer money;
    private Integer status;
}
