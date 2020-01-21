package com.developers.demo_stock.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.developers.demo_stock.entity.Product;
import com.developers.demo_stock.entity.ProductBrand;
import com.developers.demo_stock.entity.ProductColor;
import com.developers.demo_stock.entity.ProductFamily;
import com.developers.demo_stock.entity.ProductPresentation;
import com.developers.demo_stock.entity.ProductSize;
import com.developers.demo_stock.repository.ProductBrandRepository;
import com.developers.demo_stock.repository.ProductColorRepository;
import com.developers.demo_stock.repository.ProductFamilyRepository;
import com.developers.demo_stock.repository.ProductPresentationRepository;
import com.developers.demo_stock.repository.ProductRepository;
import com.developers.demo_stock.repository.ProductSizeRepository;

@Service
public class ProductPresentationServiceImpl implements ProductPresentationService {

    @Autowired
    ProductPresentationRepository productPresentationRepo;

    @Autowired
    ProductRepository productRepo;

    @Autowired
    ProductFamilyRepository productFamilyRepo;

    @Autowired
    ProductBrandRepository productBrandRepo;

    @Autowired
    ProductColorRepository productColorRepo;

    @Autowired
    ProductSizeRepository productSizeRepo;

    @Override
    public Iterable<ProductPresentation> getAllProductPresentation() {
        return productPresentationRepo.findAll();
    }

    @Override
    public void save(ProductPresentation productPresentation) {
        productPresentationRepo.save(productPresentation);

    }

    @Override
    public void delete(Integer id) {
        productPresentationRepo.deleteById(id);

    }

    @Override
    public Optional<ProductPresentation> findById(Integer id) {
        return productPresentationRepo.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Product> findAllProduct() {
        return productRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<ProductSize> findAllProductSize() {
        return productSizeRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<ProductColor> findAllProductColor() {
        return productColorRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<ProductBrand> findAllProductBrand() {
        return productBrandRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<ProductFamily> findAllProductFamily() {
        return productFamilyRepo.findAll();
    }

}
