package com.example.Scheduling.Assignment.services;

import com.example.Scheduling.Assignment.entities.Product;
import com.example.Scheduling.Assignment.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import java.io.Serial;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepo productRepo;

    @Override
    public String addProduct(Product p) {
        productRepo.save(p);
        return "Successfully Added Product";
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Optional<Product> getProduct(int pid) {
        return productRepo.findById(pid);
    }
}
