package com.maria.countries.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.maria.countries.service.ApiService;



@Controller
public class CountryController {
	private final ApiService apiService;
	
	public CountryController(ApiService apiService) {
		this.apiService = apiService;
	}

	@RequestMapping(value="country", method=RequestMethod.GET)
	public String coutryLang(Model model) {		
		List<Object[]> table = apiService.listDojoN();
		model.addAttribute("table", table);
		
		List<Object[]> table1 = apiService.TotalCities();
		model.addAttribute("table1", table1);
		
		List<Object[]> table2 = apiService.MexPopulation();
		model.addAttribute("table2", table2);
	
		List<Object[]> table3 = apiService.LangPercentage();
		model.addAttribute("table3", table3);
		
		List<Object[]> table4 = apiService.SurfPop();
		model.addAttribute("table4", table4);
		
		List<Object[]> table5 = apiService.Monarchy();
		model.addAttribute("table5", table5);
		
		List<Object[]> table6 = apiService.District();
		model.addAttribute("table6", table6);
		
		List<Object[]> table7 = apiService.Region();
		model.addAttribute("table7", table7);
		
		
		return "/show.jsp";
	}
	
}