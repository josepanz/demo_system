package com.developers.demo_stock.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.developers.demo_stock.entity.Country;

public interface CountryService {

    public Iterable<Country> getAllCountry();

    public Page<Country> findAll(Pageable pageable);
    
    public void save(Country country);

    public void delete(Integer id);

    public Optional<Country> findById(Integer id);

}
