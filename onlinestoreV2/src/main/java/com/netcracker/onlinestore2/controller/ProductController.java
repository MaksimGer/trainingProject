package com.netcracker.onlinestore2.controller;

import com.netcracker.onlinestore2.domain.entity.*;
import com.netcracker.onlinestore2.service.category.CategoryService;
import com.netcracker.onlinestore2.service.categoryparam.CategoryParamService;
import com.netcracker.onlinestore2.service.params.ParamsService;
import com.netcracker.onlinestore2.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ParamsService paramsService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryParamService categoryParamService;

    @GetMapping("/product/{id}")
    public String main(@PathVariable("id") Long id,  Model model){
        Product product = productService.findById(id);
        Long categoryId = product.getCategory().getId();
        Category category = categoryService.findById(categoryId);
        Iterable<Params> allParamsByProduct = paramsService.findAllByProduct(product);

        model.addAttribute("params", allParamsByProduct);
        model.addAttribute("product", product);
        model.addAttribute("category", category);

        return "productInfo";
    }

    @GetMapping("/addProduct/{categoryId}")
    public String createProduct(@PathVariable("categoryId") Long categoryId, Model model){
        Category category = categoryService.findById(categoryId);
        Iterable<CategoryParam> params = categoryParamService.findAllByCategory(category);

        model.addAttribute("params", params);
        model.addAttribute("category", category);

        return "createProduct";
    }

    @GetMapping("/delete/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId){
        Product curProduct = productService.findById(productId);
        Long categoryId = curProduct.getCategory().getId();
        Iterable<Params> paramsByProduct = paramsService.findAllByProduct(curProduct);

        paramsService.deleteAll(paramsByProduct);
        productService.delete(curProduct);

        return "redirect:/categories/category/" + categoryId;
    }

    @GetMapping("/update/{productId}")
    public String updateProduct(@PathVariable("productId") Long productId, Model model){
        Product curProduct = productService.findById(productId);
        List<Params> paramsByProduct = paramsService.findAllByProduct(curProduct);
        List<CategoryParam> paramsByCategory = categoryParamService.findAllByCategory(curProduct.getCategory());

        for(CategoryParam categoryParam: paramsByCategory){
            Attribute categoryParamAttribute = categoryParam.getAttribute();
            Params addParams = new Params(curProduct, categoryParamAttribute, "-");

            if(!paramsByProduct.contains(addParams)){
                paramsService.save(addParams);
                paramsByProduct.add(addParams);
            }
        }

        model.addAttribute("product", curProduct);
        model.addAttribute("params", paramsByProduct);

        return "updateProduct";
    }

    @PostMapping("/addProduct/{categoryId}")
    public String addProduct(@PathVariable("categoryId") Long categoryId,
                             @RequestParam Map<String, String> allRequestParams){

        String productName = allRequestParams.get("productName");
        Category category =  categoryService.findById(categoryId);

        Product newProduct = new Product(productName, category);
        productService.save(newProduct);

        Iterable<CategoryParam> categoryParamsIterable = categoryParamService.findAllByCategory(category);

        for(CategoryParam categoryParam: categoryParamsIterable){

            String value = allRequestParams.get("value["+categoryParam.getAttribute().getId()+"]");
            Attribute attribute = categoryParam.getAttribute();

            Params params = new Params(newProduct, attribute, value);

            paramsService.save(params);
        }

        return "redirect:/products/product/"+newProduct.getId();
    }

    @PostMapping("updateProduct")
    public String updateProduct(@RequestParam Map<String, String> allRequestParam){
        Long productId = Long.parseLong(allRequestParam.get("productId"));
        String productName = allRequestParam.get("productName");
        Category category = productService.findById(productId).getCategory();

        productService.update(productId, productName, category);

        Product curProduct = productService.findById(productId);
        List<Params> paramsByProduct = paramsService.findAllByProduct(curProduct);

        for(Params params: paramsByProduct){
            Long id = params.getId();
            Product product = params.getProduct();
            Attribute attribute = params.getAttribute();
            String valueName = "value["+attribute.getId()+"]";
            String value = allRequestParam.get(valueName);

            paramsService.update(id, product, attribute, value);
        }

        return "redirect:/products/product/"+productId;
    }
}
