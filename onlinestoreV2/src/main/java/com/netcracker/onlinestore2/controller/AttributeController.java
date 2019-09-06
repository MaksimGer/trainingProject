package com.netcracker.onlinestore2.controller;

import com.netcracker.onlinestore2.domain.entity.Attribute;
import com.netcracker.onlinestore2.domain.entity.CategoryParam;
import com.netcracker.onlinestore2.domain.entity.Params;
import com.netcracker.onlinestore2.service.attribute.AttributeService;
import com.netcracker.onlinestore2.service.categoryparam.CategoryParamService;
import com.netcracker.onlinestore2.service.params.ParamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/attributes")
public class AttributeController {

    @Autowired
    private AttributeService attributeService;

    @Autowired
    private ParamsService paramsService;

    @Autowired
    CategoryParamService categoryParamService;

    @GetMapping("")
    public String getAllAttributes(Model model){
        model.addAttribute("attributes", attributeService.findAll());
        return "attributesList";
    }

    @PostMapping("/addAttribute")
    public String addAttribute(@RequestParam("name") String name, Model model){
        attributeService.save(new Attribute(name));

        model.addAttribute("attributes", attributeService.findAll());

        return "attributesList";
    }

    @GetMapping("/delete/{id}")
    public String deleteAttr(@PathVariable("id") Long id, Model model){
        Attribute curAttribute = attributeService.findById(id);
        List<Params> paramsByAttr = paramsService.findAllByAttribute(curAttribute);
        List<CategoryParam> categoryParamsByAttr = categoryParamService.findAllByAttribute(curAttribute);

        if(paramsByAttr.isEmpty() && categoryParamsByAttr.isEmpty()){
            attributeService.deleteById(id);
        } else{
            model.addAttribute("attribute", attributeService.findById(id));
            return "confirmOfDelAttribute";
        }

        return "redirect:/attributes";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Model model){
        model.addAttribute("attribute", attributeService.findById(id));

        return "updateAttribute";
    }

    @PostMapping("/updateAttribute")
    public String updateAttribute(@ModelAttribute("attribute") Attribute attribute){
        attributeService.update(attribute.getId(), attribute.getName());

        return "redirect:/attributes";
    }

    @PostMapping("/confirmedDeletion/{id}")
    public String confirmedDeletion(@PathVariable("id") Long attributeId){
        Attribute curAttribute = attributeService.findById(attributeId);
        List<Params> paramsByAttr = paramsService.findAllByAttribute(curAttribute);
        List<CategoryParam> categoryParamsByAttr = categoryParamService.findAllByAttribute(curAttribute);

        paramsService.deleteAll(paramsByAttr);
        categoryParamService.deleteAll(categoryParamsByAttr);

        return "redirect:/attributes";
    }

}
