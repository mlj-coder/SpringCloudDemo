package com.mlj.product.service;

import com.mlj.product.entity.Product;

public interface ProductService {
    /**
     * 根据id查询
     */
    Product findById(long id);
    /**
     * 保存
     */
    void save(Product product);
    /**
     * 更新
     */
    void update(Product product);
    /**
     * 删除
     */
    void delete(long id);
}
