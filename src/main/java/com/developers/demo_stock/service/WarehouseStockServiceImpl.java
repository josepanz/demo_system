package com.developers.demo_stock.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.developers.demo_stock.entity.Warehouse;
import com.developers.demo_stock.entity.ProductPresentation;
import com.developers.demo_stock.entity.WarehouseStock;
import com.developers.demo_stock.repository.WarehouseRepository;
import com.developers.demo_stock.repository.ProductPresentationRepository;
import com.developers.demo_stock.repository.WarehouseStockRepository;

@Service
public class WarehouseStockServiceImpl implements WarehouseStockService {

    @Autowired
    WarehouseStockRepository warehouseStockRepo;

    @Autowired
    ProductPresentationRepository productPresentationRepo;

    @Autowired
    WarehouseRepository warehouseRepo;

    @Override
    public Iterable<WarehouseStock> getAllWarehouseStock() {
        return warehouseStockRepo.findAll();
    }

    @Override
    public void save(WarehouseStock warehouseStock) {
        warehouseStockRepo.save(warehouseStock);

    }

    @Override
    public void delete(Integer id) {
        warehouseStockRepo.deleteById(id);

    }

    @Override
    public Optional<WarehouseStock> findById(Integer id) {
        return warehouseStockRepo.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<ProductPresentation> findAllProductPresentation() {
        return productPresentationRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Warehouse> findAllWarehouse() {
        return warehouseRepo.findAll();
    }


}
