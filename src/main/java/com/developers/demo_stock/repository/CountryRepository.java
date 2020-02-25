package com.developers.demo_stock.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.developers.demo_stock.entity.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Integer> {

	Page<Country> findAll(Pageable pageable);

    /*tiene metodos, pero si queremos crear nuestros propios metodos los creamos aqui*/
}
