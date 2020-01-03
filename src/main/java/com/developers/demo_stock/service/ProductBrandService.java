package com.developers.demo_stock.service;

import java.util.Optional;

import com.developers.demo_stock.entity.ProductBrand;

public interface ProductBrandService {

    public Iterable<ProductBrand> getAllProductBrand();

    public void save(ProductBrand productBrand);

    public void delete(Integer id);

    public Optional<ProductBrand> findById(Integer id);

}
