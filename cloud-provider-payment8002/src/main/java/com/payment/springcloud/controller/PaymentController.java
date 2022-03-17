package com.payment.springcloud.controller;

import com.commons.springcloud.entities.CommonResult;
import com.commons.springcloud.entities.Payment;
import com.payment.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableEurekaClient
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        Integer integer = paymentService.create(payment);
        if(integer > 0){
            return new CommonResult(200,"创建成功 serverPort:"+serverPort,integer);
        }else {
            return new CommonResult(201,"创建失败 serverPort:"+serverPort,null);
        }

    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        if(payment != null){
            return new CommonResult(200,"获取成功 serverPort:"+serverPort,payment);
        }else{
            return new CommonResult(201,"暂无数据 serverPort:"+serverPort,null);
        }
    }
}
