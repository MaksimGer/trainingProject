package com.netcracker.onlinestore2.service.categoryparam;

import com.netcracker.onlinestore2.domain.entity.Attribute;
import com.netcracker.onlinestore2.domain.entity.Category;
import com.netcracker.onlinestore2.domain.entity.CategoryParam;
import com.netcracker.onlinestore2.repos.CategoryParamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryParamServiceImpl implements CategoryParamService {

    @Autowired
    CategoryParamRepo categoryParamRepo;

    @Override
    public List<CategoryParam> findAllByCategory(Category category) {
        return categoryParamRepo.findAllByCategory(category);
    }

    @Override
    public void save(CategoryParam categoryParam) {
        categoryParamRepo.save(categoryParam);
    }

    @Override
    public void deleteAll(Iterable<CategoryParam> categoryParams) {
        for(CategoryParam categoryParam: categoryParams){
            categoryParamRepo.delete(categoryParam);
        }
    }

    @Override
    public List<CategoryParam> findAllByAttribute(Attribute attribute) {
        return categoryParamRepo.findAllByAttribute(attribute);
    }

}
