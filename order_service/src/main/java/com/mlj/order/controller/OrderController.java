package com.mlj.order.controller;

import com.mlj.order.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    //注入restTemplate
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 基于ribbon的形式调用远程服务
     *  1.使用@LoadBalanced声明restTemplate
     *  2.使用服务提供者的服务名替换ip
     */
    @RequestMapping(value = "/buy/{id}",method = RequestMethod.GET)
    public Product findById(@PathVariable long id){
        //使用ribbon用微服务名称调用商品微服务
        Product forObject = restTemplate.getForObject("http://service-product/product/"+id, Product.class);
        return forObject;
    }


    /**
     * 注入一个对象 discoveryClient springEureka提供的调用注册到eurekaServer的微服务
     * 调用方法获取服务的元数据信息
     */
    @Autowired
    private DiscoveryClient discoveryClient;
    /**
     * 商品id
     * 通过订单系统，调用商品服务
     */
   /* @RequestMapping(value = "/buy/{id}",method = RequestMethod.GET)
    public Product findById(@PathVariable long id){
        //调用discovery方法,调用商品服务的注册到eurekaServer的信息
        List<ServiceInstance> instances = discoveryClient.getInstances("SERVICE-PRODUCT");
        //获取唯一的一个元数据
        ServiceInstance instance = instances.get(0);
        //拼接商品服务的元数据调用商品服务
        Product forObject = restTemplate.getForObject("http://"+instance.getHost()+":"+instance.getPort()+"/product/"+id, Product.class);
        return forObject;
    }*/
}
