package com.netcracker.onlinestore2.service.product;

import com.netcracker.onlinestore2.domain.entity.Category;
import com.netcracker.onlinestore2.domain.entity.Product;
import com.netcracker.onlinestore2.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Product> findByCategory(Category category) {
        return productRepo.findByCategory(category);
    }

    @Override
    public void update(Long id, String name, Category category) {
        Product product = productRepo.findById(id).get();
        product.setName(name);
        product.setCategory(category);
        productRepo.save(product);
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> dbProduct = productRepo.findById(id);

        if(dbProduct.isPresent()){;
            return  dbProduct.get();
        }
        return null;
    }

    @Override
    public void save(Product product) {
        productRepo.save(product);
    }

    @Override
    public void delete(Product product) {
        productRepo.delete(product);
    }
}
