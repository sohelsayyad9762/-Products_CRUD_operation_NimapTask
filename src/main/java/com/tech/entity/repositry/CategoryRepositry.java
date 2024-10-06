package com.tech.entity.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tech.entity.Category;

@Repository
public interface CategoryRepositry extends JpaRepository<Category, Integer> {

	
}
