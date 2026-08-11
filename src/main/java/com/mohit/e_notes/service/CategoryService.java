package com.mohit.e_notes.service;

import java.util.List;

import com.mohit.e_notes_DTO.CategoryDTO;
import com.mohit.e_notes_DTO.CategoryRequestDto;
import com.mohit.e_notes_DTO.CategoryResponseDto;


public interface CategoryService {

	public Boolean saveCategory(CategoryDTO category);
	
	public List<CategoryDTO> getAll();
	
	public List<CategoryResponseDto> getActiveCategory();
	
	public CategoryDTO getCategoryById(Integer id);
	
	public String deleteCategoryById(Integer id);
	
	public String softDeleteCategory(Integer id);
	
	public String updateCategory(Integer id, CategoryRequestDto categoryRequestDto);
}
