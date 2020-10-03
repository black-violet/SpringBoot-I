package com.maria.examen1.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.maria.examen1.models.Raiting;


	@Repository
	public interface RaitingRepository extends CrudRepository<Raiting, Long> {

		List<Raiting> findAll();
	
}
