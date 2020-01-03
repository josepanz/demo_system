package com.developers.demo_stock.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.developers.demo_stock.entity.Currency;
import com.developers.demo_stock.repository.CurrencyRepository;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    //inyeccion de dependecia

    /*@Transaccional: si interactua con la base de datos.
	 si un metodo no transaccional llama a un metodo 
	 transaccional dentro de la misma clase, 
	 no se iniciara una transaccion.*/
    @Autowired
    CurrencyRepository currencyRepo;

    /*transacción readonly puede ser utilizada cuando quieres que tu código lea pero no modifique ningún dato*/
    @Override
    @Transactional(readOnly = true)
    public Iterable<Currency> getAllCurrency() {
        return currencyRepo.findAll();
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        currencyRepo.deleteById(id);
    }

    @Override
    @Transactional
    public void save(Currency currency) {
        currencyRepo.save(currency);

    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Currency> findById(Integer id) {
        return currencyRepo.findById(id);
    }

}
