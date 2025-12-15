package org.carlosacademic.springbootandspringmvc.controller;


import org.carlosacademic.springbootandspringmvc.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {


    @GetMapping("/products")
    public String listProducts(Model model){
        List<Product> products = List.of(new Product("Laptop", 1000), new Product("Tablet", 500));
        model.addAttribute("products", products);
        return "products";
    }
}
