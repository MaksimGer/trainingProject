package com.netcracker.onlinestore2.repos;

import com.netcracker.onlinestore2.domain.entity.Attribute;
import org.springframework.data.repository.CrudRepository;

public interface AttributeRepo extends CrudRepository<Attribute, Long> {
    Attribute findByName(String name);
}
