package com.netcracker.onlinestore2.repos;

import com.netcracker.onlinestore2.domain.entity.Attribute;
import com.netcracker.onlinestore2.domain.entity.Category;
import com.netcracker.onlinestore2.domain.entity.CategoryParam;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryParamRepo extends CrudRepository<CategoryParam, Long> {
    List<CategoryParam> findAllByCategory(Category category);
    List<CategoryParam> findAllByAttribute(Attribute attribute);
}
