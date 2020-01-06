package com.developers.demo_stock.service;

import java.util.Optional;

import com.developers.demo_stock.entity.Departament;


public interface DepartamentService {

	  public Iterable<Departament> getAllDepartament();

	    public void save(Departament departament);

	    public void delete(Integer id);

	    public Optional<Departament> findById(Integer id);
}
