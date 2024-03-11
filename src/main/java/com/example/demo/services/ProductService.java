package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;

import jakarta.annotation.PostConstruct;

@Service
public class ProductService {
	private final ProductRepository producRepositry;

    public ProductService(ProductRepository producRepositry) {
        this.producRepositry = producRepositry;
    }
    
    @PostConstruct
    public void init() {
        this.createProducts();
        
        List<Product> products = this.getAll();
        System.out.println("Products :");
		products.forEach(p -> System.out.println(p.getName()));
    }
    
    public void createProducts() {
		List<Product> products = new ArrayList<>();
		
		products.add(new Product(58698L, "desk", "work desk", 1500.0));
		products.add(new Product(96522L, "window", "home window", 2000.0));
		products.add(new Product(78852L, "pen", "", 3.0));
		
		producRepositry.saveAll(products);
	}

    public List<Product> getAll() {
        return (List<Product>) producRepositry.findAll();
    }
    
    public Product getProductById(Long id) {
    	return producRepositry.findById(id).get();
    }
}
