package org.carlosacademic.springbootandspringmvc.controller;

import org.carlosacademic.springbootandspringmvc.model.Product;
import org.carlosacademic.springbootandspringmvc.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * If you see in the logs, the token is the same for the user session
 * And the transaction id is different for every request because of the scopes
 */
@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String getProducts(Model model){
        var products = List.of(new Product("Notebook Asus", 5000.0),
                new Product("Samsung Galaxy", 1200.0));
        model.addAttribute("products", products);

        return "products";
    }

    @PostMapping("/buy")
    public String buyProduct(Model model){
        productService.buyProduct();
        return getProducts(model);
    }
}
