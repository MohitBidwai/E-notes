package com.mohit.e_notes.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohit.e_notes.entity.Category;
import com.mohit.e_notes.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {

	private final CategoryService categoryService;
	
	@PostMapping()
	public ResponseEntity<?> saveCategory(@RequestBody Category category)
	{
		
		Boolean savedCategory = categoryService.saveCategory(category);
		
		if(savedCategory) {
			return new ResponseEntity<>("Category saved successfully", HttpStatus.OK);
		}
		
		else {
			return new ResponseEntity<>("Category not saved successfully" , HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@GetMapping
	public ResponseEntity<?> getAllCategory()
	{
		List<Category> categories = categoryService.getAll();
		
		if(CollectionUtils.isEmpty(categories))
		{
			
			return ResponseEntity.noContent().build();
		}
			
		else {
			
			return new ResponseEntity<>(categories , HttpStatus.OK);
		}
		
		
	}
}
