package com.developers.demo_stock.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.developers.demo_stock.entity.ProductFamily;
import com.developers.demo_stock.repository.ProductFamilyRepository;

@Service
public class ProductFamilyImpl implements ProductFamilyService {
	//inyeccion de dependecia
	
	/*@Transaccional: si interactua con la base de datos.
	 si un metodo no transaccional llama a un metodo 
	 transaccional dentro de la misma clase, 
	 no se iniciara una transaccion.*/
	
	@Autowired
	ProductFamilyRepository productFamilyRepo;
	
	/*transacción readonly puede ser utilizada cuando quieres que tu código lea pero no modifique ningún dato*/
	@Override
	@Transactional(readOnly = true)
	public Iterable<ProductFamily> getAllProductFamily() {
		return productFamilyRepo.findAll();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		productFamilyRepo.deleteById(id);		
	}

	@Override
	@Transactional
	public void save(ProductFamily productFamily) {
		productFamilyRepo.save(productFamily);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<ProductFamily> findById(Integer id) {	
		return productFamilyRepo.findById(id);
	}		

}
