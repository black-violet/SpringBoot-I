package com.maria.examen1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.maria.examen1.models.Raiting;
import com.maria.examen1.repositories.RaitingRepository;

@Service
public class RaitingService {
	private RaitingRepository raitingRepository;

	public RaitingService(RaitingRepository raitingRepository) {
		
		this.raitingRepository = raitingRepository;
	}
	
	public void create(Raiting raiting) {
		raitingRepository.save(raiting);
	}
	
	public Raiting findRaiting(Long id) {
		Optional<Raiting> optionalRaiting = raitingRepository.findById(id);
		if(optionalRaiting.isPresent()) {
			return optionalRaiting.get();
		}else {
			return null;
		}
	}
	
	public List<Raiting> allRaitings(){
		return (List<Raiting>) raitingRepository.findAll();
	}
	
	public void delet(Long id) {
		raitingRepository.deleteById(id);
	}
	
	public void update(Raiting raiting) {
		raitingRepository.save(raiting);
	}
}
