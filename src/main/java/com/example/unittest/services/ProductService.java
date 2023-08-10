package com.example.unittest.services;

import com.example.unittest.entity.Product;
import com.example.unittest.exception.BadRequestException;
import com.example.unittest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product) {
        if (product.getName() == null)
            throw new BadRequestException("Name of product can't null");
        return productRepository.save(product);
    }
}
