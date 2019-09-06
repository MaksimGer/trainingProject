package com.netcracker.onlinestore2.service.category;

import com.netcracker.onlinestore2.domain.entity.Category;

public interface CategoryService {
    Category findById(Long id);
    Iterable<Category> findAll();
    void save(Category category);
    Category findByName(String name);
    void deleteById(Long id);
    void update(Long id, String name);
}
