package com.payment.springcloud.service.impl;

import com.commons.springcloud.entities.Payment;
import com.payment.springcloud.dao.PaymentDao;
import com.payment.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public Integer create(Payment payment) {
       return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
