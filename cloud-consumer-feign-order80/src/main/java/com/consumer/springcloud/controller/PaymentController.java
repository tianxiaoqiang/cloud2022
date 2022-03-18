package com.consumer.springcloud.controller;

import com.commons.springcloud.entities.CommonResult;
import com.commons.springcloud.entities.Payment;
import com.consumer.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @Autowired
    PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/feign/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        CommonResult<Payment> payment = paymentFeignService.getPaymentById(id);
        return payment;
    }
}
