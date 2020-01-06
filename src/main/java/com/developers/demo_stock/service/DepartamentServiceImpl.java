package com.developers.demo_stock.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.developers.demo_stock.entity.Country;
import com.developers.demo_stock.entity.Departament;
import com.developers.demo_stock.repository.CountryRepository;
import com.developers.demo_stock.repository.DepartamentRepository;
@Service
public class DepartamentServiceImpl implements DepartamentService{
	@Autowired
	DepartamentRepository departamentRepo;
	
	@Autowired
	CountryRepository countryRepo;
	
	@Override
	public Iterable<Departament> getAllDepartament() {
		return  departamentRepo.findAll();
	}

	@Override
	public void save(Departament departament) {
		departamentRepo.save(departament);
		
	}

	@Override
	public void delete(Integer id) {
		departamentRepo.deleteById(id);
		
	}

	@Override
	public Optional<Departament> findById(Integer id) {	
		return departamentRepo.findById(id);
	}

	@Override
	  @Transactional(readOnly = true)
	public Iterable<Country> findAllCountry() {
		return countryRepo.findAll();
	}

}
