package com.netcracker.onlinestore2.service.params;

import com.netcracker.onlinestore2.domain.entity.Attribute;
import com.netcracker.onlinestore2.domain.entity.Params;
import com.netcracker.onlinestore2.domain.entity.Product;

import java.util.List;

public interface ParamsService {
    void save(Params params);
    void deleteAll(Iterable<Params> params);
    List<Params> findAllByProduct(Product product);
    List<Params> findAllByAttribute(Attribute attribute);
    Params findByProductAndAttribute(Product product, Attribute attribute);
    void update(Long id, Product product, Attribute attribute, String value);
}
