package com.tech.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.entity.Product;
import com.tech.service.ProductService;

@RestController
@RequestMapping("/products") // Optional: To group all product-related endpoints under /products
public class ProductController {

    public ProductController() {
        System.out.println("ProductController() inside");
    }

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public List<Product> createProduct(@RequestBody List<Product> products) {
        return productService.createProduct(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") int id) {
        Optional<Product> product = productService.getProductById(id);
        
        if (product.isPresent()) {
            // Product will have category details loaded due to the eager fetch
            return new ResponseEntity<>(product.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public Page<Product> getAllProducts(Pageable pageable) {
        return productService.getAllProducts(pageable);
    }


    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable("id") int id) {
        productService.deleteProductById(id);
        return "Deleted successfully";
    }

    @PutMapping("/{id}")
    public Product updateProductById(@PathVariable("id") int id, @RequestBody Product product) {
        product.setId(id);
        return productService.updateProductById(product);
    }
}