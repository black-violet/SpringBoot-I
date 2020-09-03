package com.maria.countries.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="countries")
public class Countries {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String countriesid;
	private String code;
	private String name;
	private String continent; 
	private String region;
	private short indep_year;
	private double surface_area;
	private int population;
	private double life_expectancy;
	private double gnp;
	private double gnp_old;
	private String local_name;
	private String government_form;
	private String head_of_statec;
	private int capital;
	private String code2;
	@OneToMany(mappedBy="country",fetch = FetchType.LAZY)
	private  List<Cities> cities;
	@OneToMany(mappedBy="country",fetch = FetchType.LAZY)
	private List<Languages> languages;

	
	
	public Countries() {
	
	}

	public Countries(String countriesid, String code, String name, String continent, String region, short indep_year,
			double surface_area, int population, double life_expectancy, double gnp, double gnp_old, String local_name,
			String government_form, String head_of_statec, int capital, String code2, List<Cities> cities,
			List<Languages> languages) {
		
		this.countriesid = countriesid;
		this.code = code;
		this.name = name;
		this.continent = continent;
		this.region = region;
		this.indep_year = indep_year;
		this.surface_area = surface_area;
		this.population = population;
		this.life_expectancy = life_expectancy;
		this.gnp = gnp;
		this.gnp_old = gnp_old;
		this.local_name = local_name;
		this.government_form = government_form;
		this.head_of_statec = head_of_statec;
		this.capital = capital;
		this.code2 = code2;
		this.cities = cities;
		this.languages = languages;
	}

	public List<Languages> getLanguages() {
		return languages;
	}

	public String getCountriesid() {
		return countriesid;
	}

	public List<Cities> getCities() {
		return cities;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public short getIndep_year() {
		return indep_year;
	}
	public void setIndep_year(short indep_year) {
		this.indep_year = indep_year;
	}
	public double getSurface_area() {
		return surface_area;
	}
	public void setSurface_area(double surface_area) {
		this.surface_area = surface_area;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public double getLife_expectancy() {
		return life_expectancy;
	}
	public void setLife_expectancy(double life_expectancy) {
		this.life_expectancy = life_expectancy;
	}
	public double getGnp() {
		return gnp;
	}
	public void setGnp(double gnp) {
		this.gnp = gnp;
	}
	public double getGnp_old() {
		return gnp_old;
	}
	public void setGnp_old(double gnp_old) {
		this.gnp_old = gnp_old;
	}
	public String getLocal_name() {
		return local_name;
	}
	public void setLocal_name(String local_name) {
		this.local_name = local_name;
	}
	public String getGovernment_form() {
		return government_form;
	}
	public void setGovernment_form(String government_form) {
		this.government_form = government_form;
	}
	public String getHead_of_statec() {
		return head_of_statec;
	}
	public void setHead_of_statec(String head_of_statec) {
		this.head_of_statec = head_of_statec;
	}
	public int getCapital() {
		return capital;
	}
	public void setCapital(int capital) {
		this.capital = capital;
	}
	public String getCode2() {
		return code2;
	}
	public void setCode2(String code2) {
		this.code2 = code2;
	}
	
	
	
}
