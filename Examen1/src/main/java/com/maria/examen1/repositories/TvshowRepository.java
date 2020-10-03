package com.maria.examen1.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.maria.examen1.models.Tvshow;

@Repository
public interface TvshowRepository extends CrudRepository<Tvshow,Long> {

	Tvshow findByTitle(String title);

	Optional<Tvshow> findById(Long id);
	
	List<Tvshow> findAll();
	
}
