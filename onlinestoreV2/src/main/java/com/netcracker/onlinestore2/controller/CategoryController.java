package com.netcracker.onlinestore2.controller;

import com.netcracker.onlinestore2.domain.ProductInfo;
import com.netcracker.onlinestore2.domain.entity.*;
import com.netcracker.onlinestore2.service.attribute.AttributeService;
import com.netcracker.onlinestore2.service.category.CategoryService;
import com.netcracker.onlinestore2.service.categoryparam.CategoryParamService;
import com.netcracker.onlinestore2.service.params.ParamsService;
import com.netcracker.onlinestore2.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private AttributeService attributeService;

    @Autowired
    CategoryParamService categoryParamService;

    @Autowired
    ParamsService paramsService;

    @GetMapping()
    public String main(Model model){
        model.addAttribute("categories", categoryService.findAll());
        return "categoriesList";
    }

    @GetMapping("/category/{id}")
    public String getById(@PathVariable("id") Long id, Model model){
        Category category = categoryService.findById(id);
        Iterable<Product> products = productService.findByCategory(category);
        Attribute priceAttr = attributeService.findByName("price");
        Attribute countAttr = attributeService.findByName("count");

        List<ProductInfo> productInfoList = new ArrayList<>();

        for(Product product: products){
            String priceStr = paramsService.findByProductAndAttribute(product, priceAttr).getValue();
            String countStr = paramsService.findByProductAndAttribute(product, countAttr).getValue();

            int price = Integer.parseInt(priceStr);
            int count = Integer.parseInt(countStr);
            int orderCount = 0;

            ProductInfo productInfo = new ProductInfo(product, price, count, orderCount);
            productInfoList.add(productInfo);
        }

        model.addAttribute("category", category);
        model.addAttribute("products", products);
        model.addAttribute("productInfoList", productInfoList);

        return "showCategory";
    }

    @GetMapping("/addCategory")
    public String createCategory(Model model){

        model.addAttribute("attributes", attributeService.findAll());

        return "createCategory";
    }

    @GetMapping("/delete/{id}")
    public String deleteAttr(@PathVariable("id") Long id, Model model){
        Category curCategory = categoryService.findById(id);
        List<Product> products = productService.findByCategory(curCategory);

        if(products.isEmpty()){
            Iterable<CategoryParam> allParamsByCategory = categoryParamService.findAllByCategory(curCategory);
            categoryParamService.deleteAll(allParamsByCategory);
            categoryService.deleteById(id);
        }else{
            model.addAttribute("category", curCategory);
            model.addAttribute("products", products);
            return "confirmOfDelCategory";
        }

        model.addAttribute("categories", categoryService.findAll());
        return "redirect:/categories";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Model model){
        Category curCategory = categoryService.findById(id);
        model.addAttribute("category", curCategory);
        model.addAttribute("attributes", attributeService.findAll());

        return "updateCategory";
    }

    @PostMapping("/updateCategory")
    public String updateAttribute(@RequestParam Map<String, String> allRequestParam){
        Long categoryId = Long.parseLong(allRequestParam.get("categoryId"));
        String categoryName = allRequestParam.get("categoryName");
        categoryService.update(categoryId, categoryName);
        Category curCategory = categoryService.findById(categoryId);
        Iterable<Attribute> attributes = attributeService.findAll();

        categoryParamService.deleteAll(categoryParamService.findAllByCategory(curCategory));

        for(Attribute attribute: attributes){
            if(allRequestParam.containsKey("attribute["+attribute.getId()+"]")){
                CategoryParam newCategoryParam = new CategoryParam(curCategory, attribute);
                categoryParamService.save(newCategoryParam);
            }
        }

        return "redirect:/categories";
    }

    @PostMapping("/addCategory")
    public String addCategory(@RequestParam Map<String, String> allRequestParam){
        String categoryName = allRequestParam.get("categoryName");
        Category newCategory = new Category(categoryName);
        categoryService.save(newCategory);
        Iterable<Attribute> attributes = attributeService.findAll();

        for(Attribute attribute: attributes){
            if(allRequestParam.containsKey("attribute["+attribute.getId()+"]")){
                CategoryParam newCategoryParam = new CategoryParam(newCategory, attribute);
                categoryParamService.save(newCategoryParam);
            }
        }

        return "redirect:/categories/category/"+newCategory.getId();
    }

    @PostMapping("/confirmedDeletion/{id}")
    public String confirmedDeletion(@PathVariable("id") Long categoryId){
        Category curCategory = categoryService.findById(categoryId);
        List<Product> products = productService.findByCategory(curCategory);

        for (Product curProduct: products){
            Iterable<Params> allProductParams = paramsService.findAllByProduct(curProduct);
            paramsService.deleteAll(allProductParams);
            productService.delete(curProduct);
        }
        Iterable<CategoryParam> allCategoryParams = categoryParamService.findAllByCategory(curCategory);
        categoryParamService.deleteAll(allCategoryParams);
        categoryService.deleteById(categoryId);

        return "redirect:/categories";
    }
}
