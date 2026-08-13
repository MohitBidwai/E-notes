package com.mohit.e_notes.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mohit.e_notes.entity.Category;
import com.mohit.e_notes.exception.ResourceNotFoundException;
import com.mohit.e_notes.repository.CategoryRepository;
import com.mohit.e_notes.service.CategoryService;
import com.mohit.e_notes_DTO.CategoryDTO;
import com.mohit.e_notes_DTO.CategoryRequestDto;
import com.mohit.e_notes_DTO.CategoryResponseDto;

import jakarta.transaction.Transactional;
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
		
		List<Category> categoryList = categoryRepository.findByIsDeletedFalse();
		
		 List<CategoryDTO> categoryDtoList = categoryList.stream().map(cat->mapper.map(cat,CategoryDTO.class)).toList();
		
		return categoryDtoList;
	}

	@Override
	public List<CategoryResponseDto> getActiveCategory() {
		// TODO Auto-generated method stub
		 List<Category> activeCategories = categoryRepository.findByIsActiveTrueAndIsDeletedFalse();
		List<CategoryResponseDto> list = activeCategories.stream()
				.map(cat->mapper.map(cat, CategoryResponseDto.class)).toList();
		
		return list;
	}

	@Override
	public CategoryDTO getCategoryById(Integer id) {
		// TODO Auto-generated method stub
		Category category = categoryRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Category Not found with id " + id));
		
		if(!(ObjectUtils.isEmpty(category)))
		{
//		  Category categoryObject = category.get();
			
		  return mapper.map(category, CategoryDTO.class);
		}
		
		
		return null;
	}

	@Override
	@Transactional
	public String deleteCategoryById(Integer id) {
		// TODO Auto-generated method stub
		
//		Optional<Category> category = categoryRepository.findById(id);
//		if(category.isPresent())
//		{
//		   categoryRepository.deleteById(id);
//		   return "Category deleted with successfully"+id;
//		}
//		else {
//			return  "Category not found with id : " + id;
//		}
		
		int value = categoryRepository.deleteCategoryById(id);
		if(value == 0)
		{
			return "Category with ID not found" + id;
			
		}
		
		else {
			return " Category deleted successfully " + id;
		}
	}

	@Override
	@Transactional
	public String softDeleteCategory(Integer id) {
		// TODO Auto-generated method stub
		
		Optional<Category> category = categoryRepository.findById(id);
		if(category.isPresent())
		{
		   category.get().setIsDeleted(true);
		   return "Category soft deleted  successfully"+id;
		}
		else {
			return  "Category not found with id : " + id;
		}
		
		
	}

	@Override
	public String updateCategory(Integer id, CategoryRequestDto categoryRequestDto) {
		// TODO Auto-generated method stub
		Optional<Category> category = categoryRepository.findById(id);
		if(category.isEmpty()) 
		{
			return "Category with id not found " + id;
		}
		
		
		Category categoryToUpdate = category.get();
		mapper.map(categoryRequestDto,categoryToUpdate);
		categoryToUpdate.setUpdatedBy(1);
		categoryToUpdate.setUpdatedOn(new Date());
		categoryRepository.save(categoryToUpdate);
		
		return "Category updated successfully with id : " + id; 
		
		}
		
		
		
		
	}

