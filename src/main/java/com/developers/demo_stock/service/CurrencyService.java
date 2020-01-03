package com.developers.demo_stock.service;

import java.util.Optional;

import com.developers.demo_stock.entity.Currency;

public interface CurrencyService {

    public Iterable<Currency> getAllCurrency();

    public void save(Currency country);

    public void delete(Integer id);

    public Optional<Currency> findById(Integer id);

}
