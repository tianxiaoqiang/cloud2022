package com.consumer.ribbonRule;

import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义负载均衡方式
 */
@Configuration
public class RibbonRule {
    @Bean
    public RandomRule randomRule(){
        return  new RandomRule(); //定义随机负载均衡方式
    }
}
