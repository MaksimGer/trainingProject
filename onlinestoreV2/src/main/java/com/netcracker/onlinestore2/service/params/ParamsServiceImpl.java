package com.netcracker.onlinestore2.service.params;

import com.netcracker.onlinestore2.domain.entity.Attribute;
import com.netcracker.onlinestore2.domain.entity.Params;
import com.netcracker.onlinestore2.domain.entity.Product;
import com.netcracker.onlinestore2.repos.ParamsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParamsServiceImpl implements ParamsService {
    @Autowired
    ParamsRepo paramsRepo;

    @Override
    public void save(Params params) {
        paramsRepo.save(params);
    }

    @Override
    public void deleteAll(Iterable<Params> params) {
        for(Params param: params){
            paramsRepo.delete(param);
        }
    }

    @Override
    public List<Params> findAllByProduct(Product product) {
        return paramsRepo.findAllByProduct(product);
    }

    @Override
    public List<Params> findAllByAttribute(Attribute attribute) {
        return paramsRepo.findAllByAttribute(attribute);
    }

    @Override
    public Params findByProductAndAttribute(Product product, Attribute attribute) {
        return paramsRepo.findByProductAndAttribute(product, attribute);
    }

    @Override
    public void update(Long id, Product product, Attribute attribute, String value) {
        Optional<Params> byId = paramsRepo.findById(id);
        Params params;

        if(byId.isPresent()){
            params = byId.get();
            params.setProduct(product);
            params.setAttribute(attribute);
            params.setValue(value);
            paramsRepo.save(params);
        }
    }
}
