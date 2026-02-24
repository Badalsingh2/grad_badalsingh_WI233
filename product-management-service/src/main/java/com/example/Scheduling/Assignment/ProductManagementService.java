package com.example.Scheduling.Assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductManagementService {

	public static void main(String[] args) {
		SpringApplication.run(ProductManagementService.class, args);
	}

}
