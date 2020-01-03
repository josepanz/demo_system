package com.developers.demo_stock.repository;

import com.developers.demo_stock.entity.ProductSize;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSizeRepository extends CrudRepository<ProductSize, Integer> {

    /*tiene metodos, pero si queremos crear nuestros propios metodos los creamos aqui*/
}
