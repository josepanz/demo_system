package com.developers.demo_stock.service;

import java.util.Optional;

import com.developers.demo_stock.entity.ProductColor;

public interface ProductColorService {

    public Iterable<ProductColor> getAllProductColor();

    public void save(ProductColor productColor);

    public void delete(Integer id);

    public Optional<ProductColor> findById(Integer id);

}
