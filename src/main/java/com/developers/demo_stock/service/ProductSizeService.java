package com.developers.demo_stock.service;

import java.util.Optional;

import com.developers.demo_stock.entity.ProductSize;

public interface ProductSizeService {

    public Iterable<ProductSize> getAllProductSize();

    public void save(ProductSize productSize);

    public void delete(Integer id);

    public Optional<ProductSize> findById(Integer id);

}
