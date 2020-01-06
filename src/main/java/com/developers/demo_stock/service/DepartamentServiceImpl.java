package com.developers.demo_stock.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.developers.demo_stock.entity.Departament;
import com.developers.demo_stock.repository.DepartamentRepository;
@Service
public class DepartamentServiceImpl implements DepartamentService{
	@Autowired
	DepartamentRepository departamentRepo;
	
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

}
