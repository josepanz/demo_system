package com.developers.demo_stock.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.developers.demo_stock.entity.CivilStatus;
import com.developers.demo_stock.repository.CivilStatusRepository;

@Service
public class CivilStatusServiceImpl implements CivilStatusService {
    //inyeccion de dependecia

    /*@Transaccional: si interactua con la base de datos.
	 si un metodo no transaccional llama a un metodo 
	 transaccional dentro de la misma clase, 
	 no se iniciara una transaccion.*/
    @Autowired
    CivilStatusRepository civilStatusRepo;

    /*transacción readonly puede ser utilizada cuando quieres que tu código lea pero no modifique ningún dato*/
    @Override
    @Transactional(readOnly = true)
    public Iterable<CivilStatus> getAllCivilStatus() {
        return civilStatusRepo.findAll();
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        civilStatusRepo.deleteById(id);
    }

    @Override
    @Transactional
    public void save(CivilStatus civilStatus) {
        civilStatusRepo.save(civilStatus);

    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CivilStatus> findById(Integer id) {
        return civilStatusRepo.findById(id);
    }

}
