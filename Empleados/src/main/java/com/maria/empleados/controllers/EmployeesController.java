package com.maria.empleados.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.maria.empleados.models.Employees;
import com.maria.empleados.services.ApiService;

@Controller
@RequestMapping(value="employe")
public class EmployeesController {
	
	private final ApiService apiService;
	
	public EmployeesController(ApiService apiService) {
	this.apiService= apiService;
	}
	
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String newDojo(@ModelAttribute("employe") Employees employe) {
		return "newEmploye.jsp";
	}

	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String submit(@Valid @ModelAttribute("employe") Employees employe, BindingResult result) {	
			if (result.hasErrors()) {
				return "newEmploye.jsp";
			}else {
				apiService.createEmploy(employe);
				return "redirect:new";
			}
	}
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public String show(@PathVariable("id") Long id, Model model) {		
		Employees employe = apiService.findEmploye(id);
		model.addAttribute("employe", employe);
	
		return "show.jsp";
	}	
}
