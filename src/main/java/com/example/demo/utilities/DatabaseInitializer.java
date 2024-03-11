package com.example.demo.utilities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;

@Component
public class DatabaseInitializer {
	@Autowired
	private ProductRepository productRepository;
	
	public void CreateProducts() {
		List<Product> products = new ArrayList<>();
		
		products.add(new Product(58698L, "desk", "work desk", 1500.0));
		products.add(new Product(96522L, "window", "home window", 2000.0));
		products.add(new Product(78852L, "pen", "", 3.0));
		
		productRepository.saveAll(products);
	}
}
