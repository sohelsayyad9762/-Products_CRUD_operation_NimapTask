package com.tech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.entity.Product;
import com.tech.entity.repositry.ProductRepositry;

@Service
public class ProductService {

	public ProductService() {
		System.out.println("inside ProductService()");
	}
	
	@Autowired
	ProductRepositry productRepositry;
	
	public List<Product> CreateProduct(List<Product> product) {
		return productRepositry.saveAll(product);
	}
	
	public Optional<Product> GetByIdProduct(int id) {
		return productRepositry.findById(id);
	}
	
	public List<Product> GetAllProduct() {
		return productRepositry.findAll();
	}
	
	public void deleteProductyById(int id) {
		productRepositry.deleteById(id);
	}
	
public Product UpdateProductById(Product product) {
		
		productRepositry.findById(product.getId()).orElseThrow();
		return productRepositry.save(product);
	}
}
