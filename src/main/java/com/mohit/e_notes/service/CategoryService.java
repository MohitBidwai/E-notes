package com.mohit.e_notes.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.mohit.e_notes.entity.Category;
import com.mohit.e_notes_DTO.CategoryDTO;
import com.mohit.e_notes_DTO.CategoryResponseDto;


public interface CategoryService {

	public Boolean saveCategory(CategoryDTO category);
	public List<CategoryDTO> getAll();
	public List<CategoryResponseDto> getActiveCategory();
}
