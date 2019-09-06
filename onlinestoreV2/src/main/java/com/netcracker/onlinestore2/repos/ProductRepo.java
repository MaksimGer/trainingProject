package com.netcracker.onlinestore2.repos;

import com.netcracker.onlinestore2.domain.entity.Category;
import com.netcracker.onlinestore2.domain.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepo extends CrudRepository<Product, Long> {
    List<Product> findByCategory(Category category);
}
