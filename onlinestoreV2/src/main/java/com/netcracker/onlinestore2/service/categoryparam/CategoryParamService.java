package com.netcracker.onlinestore2.service.categoryparam;

import com.netcracker.onlinestore2.domain.entity.Attribute;
import com.netcracker.onlinestore2.domain.entity.Category;
import com.netcracker.onlinestore2.domain.entity.CategoryParam;

import java.util.List;

public interface CategoryParamService {
    List<CategoryParam> findAllByCategory(Category category);
    void save(CategoryParam categoryParam);
    void deleteAll(Iterable<CategoryParam> categoryParams);
    List<CategoryParam> findAllByAttribute(Attribute attribute);
}
