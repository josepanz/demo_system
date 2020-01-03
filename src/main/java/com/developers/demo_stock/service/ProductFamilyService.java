package com.developers.demo_stock.service;

import java.util.Optional;

import com.developers.demo_stock.entity.ProductFamily;

public interface ProductFamilyService {

    public Iterable<ProductFamily> getAllProductFamily();

    public void save(ProductFamily productFamily);

    public void delete(Integer id);

    public Optional<ProductFamily> findById(Integer id);

}
