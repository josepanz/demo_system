package com.developers.demo_stock.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.developers.demo_stock.entity.Departament;
@Repository
public interface DepartamentRepository extends CrudRepository<Departament, Integer>{

}
