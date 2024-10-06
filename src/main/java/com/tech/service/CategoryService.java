package com.tech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.entity.Category;
import com.tech.entity.repositry.CategoryRepositry;

@Service
public class CategoryService {

	public CategoryService() {
		System.out.println("inside CategoryService() constructor");
	}

	@Autowired
	CategoryRepositry categoryRepositry;

	public List<Category> CreateCategory(List<Category> category) {
		return categoryRepositry.saveAll(category);
	}

	public List<Category> GetCategory() {
		return categoryRepositry.findAll();
	}

	public Optional<Category> GetCategoryById(int id) {
		return categoryRepositry.findById(id);
	}

	public void deleteCategoryById(int id) {
		categoryRepositry.deleteById(id);
	}

	public Category UpdateCategoryById(Category category) {
		
		categoryRepositry.findById(category.getId()).orElseThrow();
		return categoryRepositry.save(category);
	}
	

}
