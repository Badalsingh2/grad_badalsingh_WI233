package com.example.Scheduling.Assignment.services;

import com.example.Scheduling.Assignment.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public String addProduct(Product p);
    public List<Product> getAllProducts();
    public Optional<Product> getProduct(int pid);
}
