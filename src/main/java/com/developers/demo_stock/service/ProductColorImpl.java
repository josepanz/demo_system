package com.developers.demo_stock.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.developers.demo_stock.entity.ProductColor;
import com.developers.demo_stock.repository.ProductColorRepository;

@Service
public class ProductColorImpl implements ProductColorService {
    //inyeccion de dependecia

    /*@Transaccional: si interactua con la base de datos.
	 si un metodo no transaccional llama a un metodo 
	 transaccional dentro de la misma clase, 
	 no se iniciara una transaccion.*/
    @Autowired
    ProductColorRepository productColorRepo;

    /*transacción readonly puede ser utilizada cuando quieres que tu código lea pero no modifique ningún dato*/
    @Override
    @Transactional(readOnly = true)
    public Iterable<ProductColor> getAllProductColor() {
        return productColorRepo.findAll();
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        productColorRepo.deleteById(id);
    }

    @Override
    @Transactional
    public void save(ProductColor productColor) {
        productColorRepo.save(productColor);

    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ProductColor> findById(Integer id) {
        return productColorRepo.findById(id);
    }

}
