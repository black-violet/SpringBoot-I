package com.maria.commerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.maria.commerce.models.Category;
import com.maria.commerce.repositories.CategoryRepository;



@Service
public class CategoryService {

	private final CategoryRepository catRepo;
		
		public CategoryService(CategoryRepository catRepo) {
			this.catRepo = catRepo;	
		}
	public List<Category> allCat(){
		return catRepo.findAll();
	}
	
	public Category createCat(Category cat) {
		return catRepo.save(cat);
	}
	
	public Category findCat(Long id) {
		Optional<Category> optionalCat = catRepo.findById(id);
		if(optionalCat.isPresent()) {
			return optionalCat.get();
		}else {
			return null;
		}
	}
	

}

