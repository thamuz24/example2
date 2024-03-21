package com.example.service.impl;

import com.example.model.Product;
import com.example.repository.ProductCategoryRepository;
import com.example.repository.ProductRepository;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryService categoryService;
//    @Autowired
//    private ProductCategoryRepository productCategoryRepository;
    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Iterable<Product> findAllByPriceBetween(Long min, Long max) {
        return productRepository.findAllByPriceBetween(min, max);
    }

    @Override
    public Iterable<Product> findByOrderByAmountDesc() {
        return productRepository.findByOrderByAmountDesc();
    }
}
