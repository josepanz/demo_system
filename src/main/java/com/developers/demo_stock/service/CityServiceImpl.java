package com.developers.demo_stock.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.developers.demo_stock.entity.City;
import com.developers.demo_stock.entity.Departament;
import com.developers.demo_stock.repository.CityRepository;
import com.developers.demo_stock.repository.DepartamentRepository;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityRepository cityRepo;
    
    
    @Autowired
    DepartamentRepository departamentRepo;

    @Override
    @Transactional(readOnly = true)
    public Iterable<City> getAllCity() {
        return cityRepo.findAll();
    }

    @Override
    @Transactional
    public void save(City city) {
        cityRepo.save(city);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        cityRepo.deleteById(id);

    }

    @Override
    @Transactional(readOnly = true)
    public Optional<City> findById(Integer id) {
        return cityRepo.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Departament> findAllDepartament() {
        return departamentRepo.findAll();
    }

    

}
