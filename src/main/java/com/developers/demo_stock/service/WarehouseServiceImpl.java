package com.developers.demo_stock.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.developers.demo_stock.entity.CompanyBranch;
import com.developers.demo_stock.entity.Warehouse;
import com.developers.demo_stock.repository.CompanyBranchRepository;
import com.developers.demo_stock.repository.WarehouseRepository;

@Service
public class WarehouseServiceImpl implements WarehouseService {
    @Autowired
    WarehouseRepository warehouseRepo;

    @Autowired
    CompanyBranchRepository companyBranchRepo;

    @Override
    public Iterable<Warehouse> getAllWarehouse() {
        return warehouseRepo.findAll();
    }

    @Override
    public void save(Warehouse warehouse) {
        warehouseRepo.save(warehouse);

    }

    @Override
    public void delete(Integer id) {
        warehouseRepo.deleteById(id);

    }

    @Override
    public Optional<Warehouse> findById(Integer id) {
        return warehouseRepo.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<CompanyBranch> findAllCompanyBranch() {
        return companyBranchRepo.findAll();
    }



}
