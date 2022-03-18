package com.consumer.springcloud.controller;

import com.commons.springcloud.entities.CommonResult;
import com.commons.springcloud.entities.Payment;
import com.consumer.ribbonRule.RibbonRule;
import com.netflix.discovery.DiscoveryClient;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@EnableEurekaClient
@Log4j2
//配置Ribbon负载均衡算法(默认是轮询)
@RibbonClient(name="CLOUD-PAYMENT-SERVICE",configuration = RibbonRule.class)
public class OrderController {

    @Autowired
    RestTemplate restTemplate;

    //@Value("${paymentUrl.url}")
    private String paymentUrl = "http://CLOUD-PAYMENT-SERVICE";

    @PostMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(paymentUrl + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        log.error("paymentUrl:"+paymentUrl);
        return restTemplate.getForObject(paymentUrl + "/payment/get/" + id, CommonResult.class);
    }

    //getForEntity()
    @GetMapping("/consumer/paymentList/get/{id}")
    public CommonResult<Payment> getPaymentList(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(paymentUrl + "/payment/get/" + id, CommonResult.class);
        if(forEntity.getStatusCode().is2xxSuccessful()){
            return forEntity.getBody();
        }else{
            return new CommonResult<>(200,"暂无信息",null);
        }
    }
}
