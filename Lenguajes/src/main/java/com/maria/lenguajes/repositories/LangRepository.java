package com.maria.lenguajes.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.maria.lenguajes.models.Language;



@Repository 
public interface LangRepository extends CrudRepository<Language, Long> {
	List<Language> findAll();
}
