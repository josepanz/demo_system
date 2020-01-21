package com.developers.demo_stock.service;

import java.util.Optional;

import com.developers.demo_stock.entity.ProductColor;
import com.developers.demo_stock.entity.ProductBrand;
import com.developers.demo_stock.entity.ProductFamily;
import com.developers.demo_stock.entity.Product;
import com.developers.demo_stock.entity.ProductSize;
import com.developers.demo_stock.entity.ProductPresentation;

public interface ProductPresentationService {

    public Iterable<ProductPresentation> getAllProductPresentation();

    public void save(ProductPresentation productPresentation);

    public void delete(Integer id);

    public Optional<ProductPresentation> findById(Integer id);

    public Iterable<Product> findAllProduct();

    public Iterable<ProductSize> findAllProductSize();

    public Iterable<ProductColor> findAllProductColor();

    public Iterable<ProductBrand> findAllProductBrand();

    public Iterable<ProductFamily> findAllProductFamily();
}
