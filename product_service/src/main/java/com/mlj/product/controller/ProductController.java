package com.mlj.product.controller;

import com.mlj.product.entity.Product;
import com.mlj.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Value("${server.port}")
    private String prot;
    @Value("${spring.cloud.client.ip-address}")
    private String ip;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Product findById(@PathVariable long id){
        Product byId = productService.findById(id);
        byId.setProductName("请求的地址："+ip+",请求的端口："+prot);
        return byId;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.POST)
    public String save(@RequestBody Product id){
        productService.save(id);
        return "保存成功";
    }

    @PutMapping("/{id}")
    public String update(@RequestBody Product product) {
        productService.update(product);
        return "修改成功";
    }
    @DeleteMapping("/{id}")
    public String delete(Long id) {
        productService.delete(id);
        return "删除成功";
    }

}
