package com.lemonzuo.service;

import com.lemonzuo.model.Payment;

/**
 * @author LemonZuo
 * @create 2020-09-09 14:35
 */
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(Long id);
}
