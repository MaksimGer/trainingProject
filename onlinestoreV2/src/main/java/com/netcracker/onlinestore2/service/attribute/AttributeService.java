package com.netcracker.onlinestore2.service.attribute;

import com.netcracker.onlinestore2.domain.entity.Attribute;

public interface AttributeService {
    Iterable<Attribute> findAll();
    void save(Attribute attribute);
    Attribute findById(Long id);
    void update(Long id, String name);
    void deleteById(Long id);
    Attribute findByName(String name);
}
