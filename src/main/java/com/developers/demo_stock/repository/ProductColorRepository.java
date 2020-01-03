package com.developers.demo_stock.repository;

import com.developers.demo_stock.entity.ProductColor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductColorRepository extends CrudRepository<ProductColor, Integer> {

    /*tiene metodos, pero si queremos crear nuestros propios metodos los creamos aqui*/
}
