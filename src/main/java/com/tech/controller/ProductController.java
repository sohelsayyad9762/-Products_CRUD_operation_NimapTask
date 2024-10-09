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
import org.springframework.web.bind.annotation.RestController;

import com.tech.entity.Product;
import com.tech.service.ProductService;

@RestController
public class ProductController {

    public ProductController() {
        System.out.println("ProductController()  inside");
    }

    @Autowired
    private ProductService productService;

    @PostMapping("/create-product")
    public List<Product> createProduct(@RequestBody List<Product> products) {
        return productService.createProduct(products);
    }

    @GetMapping("/get-product/{id}")
    public Optional<Product> getProductById(@PathVariable("id") int id) {
        return productService.getProductById(id);
    }

    @GetMapping("/get-all-products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @DeleteMapping("/delete-product/{id}")
    public String deleteProductById(@PathVariable("id") int id) {
        productService.deleteProductById(id);
        return "Deleted successfully";
    }

    @PutMapping("/update-product/{id}")
    public Product updateProductById(@PathVariable("id") int id, @RequestBody Product product) {
        product.setId(id);
        return productService.updateProductById(product);
    }
}