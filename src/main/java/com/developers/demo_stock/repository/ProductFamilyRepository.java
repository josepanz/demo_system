package com.developers.demo_stock.repository;

import com.developers.demo_stock.entity.ProductFamily;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductFamilyRepository extends CrudRepository<ProductFamily, Integer>{
	
/*tiene metodos, pero si queremos crear nuestros propios metodos los creamos aqui*/
	
	
}
