package com.maria.commerce.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.maria.commerce.models.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{
	List<Category> findAll();
}
