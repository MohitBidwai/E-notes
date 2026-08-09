package com.mohit.e_notes.serviceImpl;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mohit.e_notes.entity.Category;
import com.mohit.e_notes.repository.CategoryRepository;
import com.mohit.e_notes.service.CategoryService;
import com.mohit.e_notes_DTO.CategoryDTO;
import com.mohit.e_notes_DTO.CategoryResponseDto;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
	
	private final CategoryRepository categoryRepository;
	private final ModelMapper mapper;

	@Override
	public Boolean saveCategory(CategoryDTO categoryDto) {
		
		//This method save the category to the db
		
		//this manual mapping but we will use model mapper instead
//		Category category = new Category();
//		category.setName(categoryDto.getName());
//		category.setDescription(categoryDto.getDescription());
//		category.setIsActive(categoryDto.getIsActive());
		Category category = mapper.map(categoryDto, Category.class);
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
	public List<CategoryDTO> getAll() {
		// TODO Auto-generated method stub
		
		List<Category> categoryList = categoryRepository.findAll();
		
		 List<CategoryDTO> categoryDtoList = categoryList.stream().map(cat->mapper.map(cat,CategoryDTO.class)).toList();
		
		return categoryDtoList;
	}

	@Override
	public List<CategoryResponseDto> getActiveCategory() {
		// TODO Auto-generated method stub
		 List<Category> activeCategories = categoryRepository.findByisActiveTrue();
		List<CategoryResponseDto> list = activeCategories.stream()
				.map(cat->mapper.map(cat, CategoryResponseDto.class)).toList();
		
		return list;
	}

}
