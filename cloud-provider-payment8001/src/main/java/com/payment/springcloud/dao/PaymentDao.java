package com.payment.springcloud.dao;

import com.commons.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

    public Integer create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
