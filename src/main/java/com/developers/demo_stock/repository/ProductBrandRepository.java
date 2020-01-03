package com.developers.demo_stock.repository;

import com.developers.demo_stock.entity.ProductBrand;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductBrandRepository extends CrudRepository<ProductBrand, Integer> {

    /*tiene metodos, pero si queremos crear nuestros propios metodos los creamos aqui*/
}
