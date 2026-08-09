package com.mohit.e_notes.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mohit.e_notes.entity.Category;


public interface CategoryService {

	public Boolean saveCategory(Category category);
	public List<Category> getAll();
}
