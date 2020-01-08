package com.developers.demo_stock.service;

import java.util.Optional;

import com.developers.demo_stock.entity.MeasuredUnit;
import com.developers.demo_stock.entity.ProductVat;
import com.developers.demo_stock.entity.Product;

public interface ProductService {

    public Iterable<Product> getAllProduct();

    public void save(Product product);

    public void delete(Integer id);

    public Optional<Product> findById(Integer id);

    public Iterable<MeasuredUnit> findAllMeasuredUnit();

    public Iterable<ProductVat> findAllProductVat();
}
