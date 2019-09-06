package com.netcracker.onlinestore2.controller;

import com.netcracker.onlinestore2.repos.ProductRepo;
import com.netcracker.onlinestore2.service.attribute.AttributeService;
import com.netcracker.onlinestore2.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AttributeService attributeService;

    @GetMapping("/")
    public String greeting(Model model) {
        return "main";
    }

//    @PostMapping("/filter")
//    public String filter(@RequestParam String filter,  Model model){
//
//        model.addAttribute("categories", categoryService.findByName(filter));
//
//        return "categoriesList";
//    }
//
//    @PostMapping("/filterProducts")
//    public String filterProduct(@RequestParam String categoryFilter,  Model model){
//        Iterable<Product> products;
//
//        if(categoryFilter != null && !categoryFilter.isEmpty()) {
//            products = productRepo.findByCategory(categoryService.findByName(categoryFilter));
//        } else {
//            products = productRepo.findAll();
//        }
//
//        model.addAttribute("products", products);
//        return "productsList";
//    }
}