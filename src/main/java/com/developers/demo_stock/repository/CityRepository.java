package com.developers.demo_stock.repository;


import java.util.Collection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.developers.demo_stock.entity.City;


@Repository
public interface CityRepository extends CrudRepository<City, Integer>{
	/*TODO: Ejemplo de como usar @Query, para este proyecto no usaremos.*/
//String query = "SELECT c.id, c.code, c.description, d.description as departament, c.creation_date , c.departament_id FROM city c join departament d on d.id = c.departament_id ";
//@Query("SELECT * FROM city")
/*@Query(value = query,nativeQuery = true)
  Collection<City> findAllCity();*/
}
