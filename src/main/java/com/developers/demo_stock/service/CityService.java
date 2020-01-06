package com.developers.demo_stock.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.developers.demo_stock.entity.City;



public interface CityService {
	    public Iterable<City> getAllCity();

	    public void save(City city);

	    public void delete(Integer id);

	    public Optional<City> findById(Integer id);
	    
	    public Collection<City> findAllCity();
	
}
