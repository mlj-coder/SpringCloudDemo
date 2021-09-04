package com.mlj.order.controller;

import com.mlj.order.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

    //注入restTemplate
    @Autowired
    private RestTemplate restTemplate;
    /**
     * 商品id
     * 通过订单系统，调用商品服务
     */

    @RequestMapping(value = "/buy/{id}",method = RequestMethod.GET)
    public Product findById(@PathVariable long id){
        Product forObject = restTemplate.getForObject("http://127.0.0.1:9001/product/1", Product.class);
        return forObject;
    }
}
