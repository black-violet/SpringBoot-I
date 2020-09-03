package com.maria.countries.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maria.countries.models.Cities;
import com.maria.countries.models.Countries;
import com.maria.countries.models.Languages;
import com.maria.countries.repositories.CitiesRepository;
import com.maria.countries.repositories.CountryRepository;
import com.maria.countries.repositories.LanguagesRepository;


@Service
public class ApiService {

	private final CountryRepository countryRepo;
	private final CitiesRepository cityRepo;
	private final LanguagesRepository langRepo;
	
	public ApiService(CountryRepository countryRepo,CitiesRepository cityRepo,LanguagesRepository langRepo) {
		this.countryRepo= countryRepo;
		this.cityRepo = cityRepo;
		this.langRepo = langRepo;
	}
	
	public List<Countries> AllCountries(Countries countries){
		return countryRepo.findAll();
	}
	
	public List<Cities> AllCities(Cities cities){
		return cityRepo.findAll();
	}
	
	public List<Languages> AllLang(Languages lang){
		return langRepo.findAll();
	}
	
	public List<Object[]> listDojoN() {
		List<Object[]> table = countryRepo.findSlovene();
		return table;
	}
	 public List<Object[]> TotalCities(){
		 List<Object[]> table1 = countryRepo.countCities();
		 return table1;
	 }
	 
	 public List<Object[]> MexPopulation(){
		 List<Object[]> table2 = countryRepo.popuLang();
		 return table2;
	 }
	 
	 public List<Object[]> LangPercentage(){
		 List<Object[]> table3 = countryRepo.pop();
		 return table3;
	 }
	
	 public List<Object[]> SurfPop(){
		 List<Object[]> table3 = countryRepo.findcountrySurfPop();
		 return table3;
	 }
	 
	 public List<Object[]> Monarchy(){
		 List<Object[]> table4 = countryRepo.findMonachSurf();
		 return table4;
	 } 
	 
	public List<Object[]> District(){
		 List<Object[]> table5 = countryRepo.findDistrict();
		 return table5;
	 } 
	 
	 public List<Object[]> Region(){
		 List<Object[]> table6 = countryRepo.findAllcitiesRegion();
		 return table6;
	 } 
	
}
