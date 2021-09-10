package com.mlj.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EntityScan("com.mlj.product.entity")
public class OrderApplication {
    /**
     * 使用spring提供的resttemplate发送http请求
     *  1.创建resttemplate对象交给容器管理
     *  2.在使用的时候，调用其方法完成操作
     *
     *  @LoadBalanced:是ribbon提供负载均衡的注解
     */
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }
}
