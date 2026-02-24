package com.example.Scheduling.Assignment.repository;

import com.example.Scheduling.Assignment.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {
}
