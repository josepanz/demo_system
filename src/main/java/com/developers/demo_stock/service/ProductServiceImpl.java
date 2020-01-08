package com.developers.demo_stock.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.developers.demo_stock.entity.MeasuredUnit;
import com.developers.demo_stock.entity.Product;
import com.developers.demo_stock.entity.ProductVat;
import com.developers.demo_stock.repository.MeasuredUnitRepository;
import com.developers.demo_stock.repository.ProductVatRepository;
import com.developers.demo_stock.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepo;

    @Autowired
    MeasuredUnitRepository measuredUnitRepo;

    @Autowired
    ProductVatRepository productVatRepo;

    @Override
    public Iterable<Product> getAllProduct() {
        return productRepo.findAll();
    }

    @Override
    public void save(Product product) {
        productRepo.save(product);

    }

    @Override
    public void delete(Integer id) {
        productRepo.deleteById(id);

    }

    @Override
    public Optional<Product> findById(Integer id) {
        return productRepo.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<MeasuredUnit> findAllMeasuredUnit() {
        return measuredUnitRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<ProductVat> findAllProductVat() {
        return productVatRepo.findAll();
    }

}
