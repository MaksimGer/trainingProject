package com.netcracker.onlinestore2.service.attribute;

import com.netcracker.onlinestore2.domain.entity.Attribute;
import com.netcracker.onlinestore2.repos.AttributeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AttributeServiceImpl implements AttributeService {
    @Autowired
    AttributeRepo attributeRepo;

    @Override
    public Iterable<Attribute> findAll() {
        return attributeRepo.findAll();
    }

    @Override
    public void save(Attribute attribute) {
        attributeRepo.save(attribute);
    }

    @Override
    public Attribute findById(Long id) {
        Optional<Attribute> dbAttribute = attributeRepo.findById(id);

        if(dbAttribute.isPresent()){;
            return  dbAttribute.get();
        }
        return null;
    }

    @Override
    public void update(Long id, String name) {
        Attribute attribute = attributeRepo.findById(id).get();
        attribute.setName(name);
        attributeRepo.save(attribute);
    }

    @Override
    public void deleteById(Long id) {
        attributeRepo.deleteById(id);
    }

    @Override
    public Attribute findByName(String name) {
        return attributeRepo.findByName(name);
    }
}
