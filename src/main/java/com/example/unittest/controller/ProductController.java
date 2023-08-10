package com.example.unittest.controller;

import com.example.unittest.entity.Product;
import com.example.unittest.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("product")
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }
}
