package com.payment.springcloud.service;

import com.commons.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {

    public Integer create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
