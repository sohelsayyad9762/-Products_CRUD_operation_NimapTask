package com.tech.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tech.entity.Product;
import com.tech.service.ProductService;

public class ProductController {

	public ProductController() {
		System.out.println("ProductController()  inside");
	}

	@Autowired
	ProductService productService;

	@PostMapping("/CreateProduct")
	public List<Product> CreateProduct(@RequestBody List<Product> products) {
		return productService.CreateProduct(products);
	}
	
	@GetMapping("/GetProductById/{id}")
	public Optional<Product> GetProductById(@PathVariable ("id") int id) {
	return	productService.GetByIdProduct(id);
	}
	
	public List<Product> GetAllProduct() {
		return productService.GetAllProduct();
	}
	
	@DeleteMapping("/deleteCategoryById/{id}")
	public String deleteProductById(@PathVariable("id") int id) {
		productService.deleteProductyById(id);

		return "deleted suceccfully";
	}
	
	@PutMapping("/UpdateProductById/product")
	public Product UpdateProductById(@RequestBody Product product) {
       
		 return UpdateProductById(product);
	}
}
