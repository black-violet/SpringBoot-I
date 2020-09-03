package com.maria.countries.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cities")
public class Cities {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int citiesid;
	private String name;
	private String country_code;
	private String district;
	private int population;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="country_id")
	private  Countries country;
	
	
	public Cities() {
		
	}
	public Cities(String name, String country_code, String district, int population, Countries country) {
	
		this.name = name;
		this.country_code = country_code;
		this.district = district;
		this.population = population;
		this.country = country;
	}
	public int getCitiesid() {
		return citiesid;
	}
	public void setCitiesid(int citiesid) {
		this.citiesid = citiesid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry_code() {
		return country_code;
	}
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	
	public Countries getCountry() {
		return country;
	}

	
}
