package com.developers.demo_stock.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.developers.demo_stock.entity.ProductSize;
import com.developers.demo_stock.repository.ProductSizeRepository;

@Service
public class ProductSizeImpl implements ProductSizeService {
    //inyeccion de dependecia

    /*@Transaccional: si interactua con la base de datos.
	 si un metodo no transaccional llama a un metodo 
	 transaccional dentro de la misma clase, 
	 no se iniciara una transaccion.*/
    @Autowired
    ProductSizeRepository productSizeRepo;

    /*transacción readonly puede ser utilizada cuando quieres que tu código lea pero no modifique ningún dato*/
    @Override
    @Transactional(readOnly = true)
    public Iterable<ProductSize> getAllProductSize() {
        return productSizeRepo.findAll();
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        productSizeRepo.deleteById(id);
    }

    @Override
    @Transactional
    public void save(ProductSize productSize) {
        productSizeRepo.save(productSize);

    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ProductSize> findById(Integer id) {
        return productSizeRepo.findById(id);
    }

}
