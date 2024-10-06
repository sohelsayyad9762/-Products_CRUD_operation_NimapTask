package com.tech.entity.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tech.entity.Product;

@Repository
public interface ProductRepositry extends JpaRepository<Product, Integer>{

}
