package com.netcracker.onlinestore2.repos;

import com.netcracker.onlinestore2.domain.entity.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepo extends CrudRepository<Category, Long> {

    Category findByName(String name);
    Optional<Category> findById(Long id);
    Iterable<Category> findAll();
}
