package com.maria.empleados.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.maria.empleados.models.Employees;


@Repository
public interface EmployeesRepositorie extends CrudRepository<Employees, Long>{

	List<Employees> findAll();
	
}
