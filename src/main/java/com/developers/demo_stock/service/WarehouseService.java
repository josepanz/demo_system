package com.developers.demo_stock.service;

import java.util.Optional;

import com.developers.demo_stock.entity.CompanyBranch;
import com.developers.demo_stock.entity.Warehouse;

public interface WarehouseService {

    public Iterable<Warehouse> getAllWarehouse();

    public void save(Warehouse warehouse);

    public void delete(Integer id);

    public Optional<Warehouse> findById(Integer id);

    public Iterable<CompanyBranch> findAllCompanyBranch();
}
