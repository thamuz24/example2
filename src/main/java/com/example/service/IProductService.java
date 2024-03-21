package com.example.service;

import com.example.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);

    void save(Product product);

    void deleteById(Long id);
    public Iterable<Product> findAllByPriceBetween(Long min,Long max);
    Iterable<Product> findByOrderByAmountDesc();

}
