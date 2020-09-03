package com.maria.countries.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.maria.countries.models.Cities;


public interface CitiesRepository extends CrudRepository<Cities, Long>{
	List<Cities> findAll();

}
