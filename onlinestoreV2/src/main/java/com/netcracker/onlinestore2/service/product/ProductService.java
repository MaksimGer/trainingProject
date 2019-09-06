package com.netcracker.onlinestore2.service.product;

import com.netcracker.onlinestore2.domain.entity.Category;
import com.netcracker.onlinestore2.domain.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findByCategory(Category category);
    void update(Long id, String name, Category category);
    Product findById(Long id);
    void save(Product product);
    void delete(Product product);

}
