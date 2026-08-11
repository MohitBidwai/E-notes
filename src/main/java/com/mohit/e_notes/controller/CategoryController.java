package com.mohit.e_notes.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohit.e_notes.entity.Category;
import com.mohit.e_notes.service.CategoryService;
import com.mohit.e_notes_DTO.CategoryDTO;
import com.mohit.e_notes_DTO.CategoryResponseDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {

	private final CategoryService categoryService;
	
	@PostMapping
	public ResponseEntity<?> saveCategory(@RequestBody CategoryDTO categoryDto)
	{
		
		Boolean savedCategory = categoryService.saveCategory(categoryDto);
		
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
		List<CategoryDTO> categories = categoryService.getAll();
		
		if(CollectionUtils.isEmpty(categories))
		{
			
			return ResponseEntity.noContent().build();
		}
			
		else {
			
			return new ResponseEntity<>(categories , HttpStatus.OK);
		}
		
	}
		
	    @GetMapping("/active")
	    public ResponseEntity<List<CategoryResponseDto>> getActiveCategory()
	    {
	    	List<CategoryResponseDto>categoryResponse = categoryService.getActiveCategory();
	    	if(CollectionUtils.isEmpty(categoryResponse))
			{
				
				return ResponseEntity.noContent().build();
			}
				
			else {
				
				return new ResponseEntity<List<CategoryResponseDto>>(categoryResponse,HttpStatus.OK);
			}
	    	
	    }
	    	
	    
	    	@GetMapping("/{id}")
	    	public ResponseEntity<?> getCategoryById(
	    	        @PathVariable Integer id) {

	    	    CategoryDTO categoryDto = categoryService.getCategoryById(id);

	    	    if (ObjectUtils.isEmpty(categoryDto)) {
	    	        return new ResponseEntity<>("Category with particular id not found: " + id ,HttpStatus.NOT_FOUND);
	    	    }

	    	    return new ResponseEntity<>(categoryDto, HttpStatus.OK);
	    	}
	    	
	    	@DeleteMapping("/{id}/permanent")
	    	public ResponseEntity<?> deleteCategory(@PathVariable Integer id)
	    	{
	    		String response = categoryService.deleteCategoryById(id);
	    		
	    		if(response.contains("not found"))
	    		{
	    			return ResponseEntity.notFound().build();
	    		}
	    		
	    		return ResponseEntity.ok().build();
	    	}
	    	
	    	@DeleteMapping("/{id}/soft-delete")
	    	public ResponseEntity<?> softDeletCategory(@PathVariable Integer id)
	    	{
	    		String response = categoryService.softDeleteCategory(id);
	    		if(response.contains("not found"))
	    		{
	    			return ResponseEntity.notFound().build();
	    		}
	    		
	    		return ResponseEntity.ok().build();
	    		
	    	}
	    	
	    
	    }
	

