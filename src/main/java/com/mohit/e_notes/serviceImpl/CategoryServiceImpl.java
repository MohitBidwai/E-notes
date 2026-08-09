package com.mohit.e_notes.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mohit.e_notes.entity.Category;
import com.mohit.e_notes.repository.CategoryRepository;
import com.mohit.e_notes.service.CategoryService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
	
	private final CategoryRepository categoryRepository;

	@Override
	public Boolean saveCategory(Category category) {
		
		//This method save the category to the db
		category.setIsDeleted(false);
		category.setCreatedBy(1);
		category.setCreatedOn(new Date());
		Category savedCategory = categoryRepository.save(category);
		
		if(ObjectUtils.isEmpty(savedCategory))
		{
			return false;
		}
		return true;
	}

	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		
		List<Category> categoryList = categoryRepository.findAll();
		
		return categoryList;
	}

}
