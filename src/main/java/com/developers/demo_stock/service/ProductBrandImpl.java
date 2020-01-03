package com.developers.demo_stock.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.developers.demo_stock.entity.ProductBrand;
import com.developers.demo_stock.repository.ProductBrandRepository;

@Service
public class ProductBrandImpl implements ProductBrandService {
	//inyeccion de dependecia
	
	/*@Transaccional: si interactua con la base de datos.
	 si un metodo no transaccional llama a un metodo 
	 transaccional dentro de la misma clase, 
	 no se iniciara una transaccion.*/
	
	@Autowired
	ProductBrandRepository productBrandRepo;
	
	/*transacción readonly puede ser utilizada cuando quieres que tu código lea pero no modifique ningún dato*/
	@Override
	@Transactional(readOnly = true)
	public Iterable<ProductBrand> getAllProductBrand() {
		return productBrandRepo.findAll();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		productBrandRepo.deleteById(id);		
	}

	@Override
	@Transactional
	public void save(ProductBrand productBrand) {
		productBrandRepo.save(productBrand);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<ProductBrand> findById(Integer id) {	
		return productBrandRepo.findById(id);
	}		

}
