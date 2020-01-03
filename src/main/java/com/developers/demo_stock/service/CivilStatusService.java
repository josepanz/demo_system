package com.developers.demo_stock.service;

import java.util.Optional;

import com.developers.demo_stock.entity.CivilStatus;

public interface CivilStatusService {

    public Iterable<CivilStatus> getAllCivilStatus();

    public void save(CivilStatus country);

    public void delete(Integer id);

    public Optional<CivilStatus> findById(Integer id);

}
