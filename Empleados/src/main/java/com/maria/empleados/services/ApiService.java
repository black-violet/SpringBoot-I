package com.maria.empleados.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.maria.empleados.models.Employees;
import com.maria.empleados.repositories.EmployeesRepositorie;

@Service
public class ApiService {

	private final EmployeesRepositorie employRepo;
	
	public ApiService(EmployeesRepositorie employRepo) {
		this.employRepo = employRepo;
		
	}
	
	public List<Employees> AllEmploy(){
		return employRepo.findAll();
	}
	
	public Employees createEmploy(Employees employ) {
		return employRepo.save(employ);
	}
	
	public Employees findEmploye(Long id) {
		Optional<Employees> optionalEmploye = employRepo.findById(id);
		if(optionalEmploye.isPresent()) {
			return optionalEmploye.get();
		}else {
			return null;
		}
	}
	public Employees updateEmploy(Long id, String first_name,String last_name) {
		Optional<Employees> optionalEmploy = employRepo.findById(id);
		if(optionalEmploy.isPresent()) {
			Employees upemploy = optionalEmploy.get();
			
			upemploy.setFirst_name(first_name);
			upemploy.setLast_name(last_name);
			return employRepo.save(upemploy);
		}else {
		return null;
		}
	}
	
}
