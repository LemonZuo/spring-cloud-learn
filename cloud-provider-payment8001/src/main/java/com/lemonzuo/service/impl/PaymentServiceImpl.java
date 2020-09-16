package com.lemonzuo.service.impl;

import com.lemonzuo.mapper.PaymentDao;
import com.lemonzuo.model.Payment;
import com.lemonzuo.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author LemonZuo
 * @create 2020-09-09 14:37
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
