package com.tech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.entity.Product;
import com.tech.entity.repositry.CategoryRepositry;
import com.tech.entity.repositry.ProductRepositry;

@Service
public class ProductService {

    @Autowired
    private ProductRepositry productRepositry;

    @Autowired
    private CategoryRepositry categoryRepository;

    public List<Product> createProduct(List<Product> products) {
        // Save categories before saving products
        products.forEach(product -> {
            if (product.getCategory() != null) {
                categoryRepository.save(product.getCategory());
            }
        });
        return productRepositry.saveAll(products);
    }

    public Optional<Product> getProductById(int id) {
        return productRepositry.findById(id);
    }

    public List<Product> getAllProducts() {
        return productRepositry.findAll();
    }

    public void deleteProductById(int id) {
        productRepositry.deleteById(id);
    }

    public Product updateProductById(Product product) {
        Product existingProduct = productRepositry.findById(product.getId()).orElseThrow();
        // Update existing product with new values
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        // Save updated product
        return productRepositry.save(existingProduct);
    }
}