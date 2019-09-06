package com.netcracker.onlinestore2.repos;

import com.netcracker.onlinestore2.domain.entity.Attribute;
import com.netcracker.onlinestore2.domain.entity.Params;
import com.netcracker.onlinestore2.domain.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ParamsRepo extends CrudRepository<Params, Long> {
    List<Params> findAllByProduct(Product product);
    List<Params> findAllByAttribute(Attribute attribute);
    Params findByProductAndAttribute(Product product, Attribute attribute);
}
