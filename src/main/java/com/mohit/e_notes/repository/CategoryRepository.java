package com.mohit.e_notes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mohit.e_notes.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	
	
	
	//Custom query
	
	@Modifying
	@Query("Delete from Category c where c.id = :id")
	int deleteCategoryById(@Param(value = "id") Integer id);

	List<Category> findByIsDeletedFalse();


	List<Category> findByIsActiveTrueAndIsDeletedFalse();
	
	
	

}
