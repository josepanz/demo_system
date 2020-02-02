package com.developers.demo_stock.service;

import java.util.Optional;

import com.developers.demo_stock.entity.ProductPresentation;
import com.developers.demo_stock.entity.Warehouse;
import com.developers.demo_stock.entity.WarehouseStock;

public interface WarehouseStockService {

    public Iterable<WarehouseStock> getAllWarehouseStock();

    public void save(WarehouseStock warehouseStock);

    public void delete(Integer id);

    public Optional<WarehouseStock> findById(Integer id);

    public Iterable<ProductPresentation> findAllProductPresentation();

    public Iterable<Warehouse> findAllWarehouse();
}
