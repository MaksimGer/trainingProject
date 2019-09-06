package com.netcracker.onlinestore2.service.category;

import com.netcracker.onlinestore2.domain.entity.Category;
import com.netcracker.onlinestore2.repos.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public Category findById(Long id) {
        Optional<Category> dbCategory = categoryRepo.findById(id);

        if(dbCategory.isPresent()){;
            return  dbCategory.get();
        }
        return null;
    }

    @Override
    public Iterable<Category> findAll() {
        return categoryRepo.findAll();
    }

    @Override
    public void save(Category category) {
        categoryRepo.save(category);
    }

    @Override
    public Category findByName(String name) {
        return categoryRepo.findByName(name);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepo.deleteById(id);
    }

    @Override
    public void update(Long id, String name) {
        Category category = categoryRepo.findById(id).get();
        category.setName(name);
        categoryRepo.save(category);
    }
}
