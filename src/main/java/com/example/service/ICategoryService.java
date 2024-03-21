package com.example.service;

import com.example.model.Category;

import java.util.Optional;

public interface ICategoryService {
    Iterable<Category> findAll();
    Optional<Category> findById(Long id);

    void save(Category product);

    void deleteById(Long id);
}
