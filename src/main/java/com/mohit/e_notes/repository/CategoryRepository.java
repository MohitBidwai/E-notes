package com.mohit.e_notes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mohit.e_notes.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	

}
