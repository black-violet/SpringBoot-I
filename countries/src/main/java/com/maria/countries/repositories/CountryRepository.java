package com.maria.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.maria.countries.models.Countries;

@Repository
public interface CountryRepository extends CrudRepository<Countries, Long>{
	List<Countries> findAll();

    // nro 1
    @Query(value="SELECT countries.name, languages.language, languages.percentage from Countries join languages on languages.country_id= countries.id where languages.language like 'slovene' Order by Languages.percentage desc", nativeQuery=true)
    List<Object[]> findSlovene();
    
    //nro 2
    @Query(value="select countries.name, Count(cities.name) from countries join cities on cities.country_id= countries.id group by countries.name Order by Count(cities.name) desc", nativeQuery=true)
    List<Object[]> countCities();
    // 3
    @Query(value="select countries.name, languages.language, languages.percentage From countries join languages on languages.country_id= countries.id where languages.percentage > 89 Order by languages.percentage desc", nativeQuery=true)
    List<Object[]> popuLang();
    //4
   @Query(value="select cities.name, cities.population From cities join countries on cities.country_id= countries.id where countries.name = 'Mexico' and cities.population > 500000 Order by cities.population desc", nativeQuery=true)
    List<Object[]> pop();
   //5 
   @Query(value="select countries.name, countries.surface_area, countries.population From countries where countries.surface_area < 501 and countries.population > 100000", nativeQuery=true)
    List<Object[]> findcountrySurfPop();
    
    //6
    @Query(value="select countries.name, countries.government_form From countries where countries.government_form like 'Constitutional Monarchy' and countries.surface_area > 200 and countries.life_expectancy >75", nativeQuery=true)
    List<Object[]>findMonachSurf();
    
    //7
     @Query(value="select countries.name as country , cities.name, cities.district, cities.population from Cities join countries on cities.country_id= countries.id where countries.name like'Argentina' and cities.district like 'Buenos Aires' and cities.population >500000", nativeQuery=true)
    List<Object[]>findDistrict();
    
    //8
    @Query(value="select countries.region, count(cities.name) from countries join cities on cities.country_id= countries.id group by countries.region order by count(cities.name) desc", nativeQuery=true)
    List<Object[]> findAllcitiesRegion();
    
}