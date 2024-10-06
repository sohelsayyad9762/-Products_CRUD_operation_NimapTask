package com.tech.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tech.entity.Category;
import com.tech.service.CategoryService;

@RestController
public class CategoryController {

	public CategoryController() {
		System.out.println("inside CategoryController() Constructor");
	}

	@Autowired
	CategoryService categoryService;

	@PostMapping("/CreateCategory")
	public List<Category> CreateCategory(@RequestBody List<Category> category) {

		return categoryService.CreateCategory(category);

	}

	@GetMapping("/GetCategory")
	public List<Category> GetCategory() {
		return categoryService.GetCategory();
	}

	@GetMapping("/GetCategoryById/{id}")
	public Optional<Category> GetCategoryById(@PathVariable("id") int id) {
		return categoryService.GetCategoryById(id);
	}

	@DeleteMapping("/deleteCategoryById/{id}")
	public String deleteCategoryById(@PathVariable("id") int id) {
		categoryService.deleteCategoryById(id);

		return "deleted suceccfully";
	}

	@PutMapping("/UpdateCategoryById/category")
	public Category UpdateCategoryById(@RequestBody Category category) {
       
		 return UpdateCategoryById(category);
	}

//	@GetMapping("/home")
//	public String name() {
//		
//		return "helooooo";
//	}

}
