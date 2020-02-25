package com.developers.demo_stock.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.developers.demo_stock.entity.Country;
import com.developers.demo_stock.repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService {
    //inyeccion de dependecia

    /*@Transaccional: si interactua con la base de datos.
	 si un metodo no transaccional llama a un metodo 
	 transaccional dentro de la misma clase, 
	 no se iniciara una transaccion.*/
    @Autowired
    CountryRepository countryRepo;

    /*transacción readonly puede ser utilizada cuando quieres que tu código lea pero no modifique ningún dato*/
    @Override
    @Transactional(readOnly = true)
    public Iterable<Country> getAllCountry() {
        return countryRepo.findAll();
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        countryRepo.deleteById(id);
    }

    @Override
    @Transactional
    public void save(Country country) {
        countryRepo.save(country);

    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Country> findById(Integer id) {
        return countryRepo.findById(id);
    }

	@Override
	public Page<Country> findAll(Pageable pageable) {
		return countryRepo.findAll(pageable);
		
	}

}
