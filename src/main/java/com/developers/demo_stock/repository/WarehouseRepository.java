package com.developers.demo_stock.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.developers.demo_stock.entity.Warehouse;

@Repository
public interface WarehouseRepository extends CrudRepository<Warehouse, Integer> {

}
