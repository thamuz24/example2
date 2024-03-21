package com.example.repository;

import com.example.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Long> {
    Iterable<Product> findAllByPriceBetween(Long min,Long max);

    Iterable<Product> findByOrderByAmountDesc();
}
