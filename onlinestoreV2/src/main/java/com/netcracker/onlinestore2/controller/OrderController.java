package com.netcracker.onlinestore2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {

    @GetMapping("/{productId}")
    public String addOrder(@PathVariable("productId") long id, Model model){

        System.out.println(model);

        return "createOrder";
    }
}
