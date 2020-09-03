package com.maria.countries.repositories;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.maria.countries.models.Languages;

public interface LanguagesRepository extends CrudRepository<Languages, Long>{
	
		List<Languages> findAll();
}
