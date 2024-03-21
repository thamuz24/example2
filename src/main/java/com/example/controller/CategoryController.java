package com.example.controller;

import com.example.model.Category;
import com.example.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/categories")
    public ResponseEntity<Iterable<Category>> showAllCategories() {
        Iterable<Category> categories = categoryService.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("/categories")
    public ResponseEntity<?> createCategory(@RequestBody Category category) {
        if(categoryService.findById(category.getCategoryId()) != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        categoryService.save(category);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<?> updateCategory(@RequestBody Category category,@PathVariable Long id) {
        Category category1 = categoryService.findById(id).get();
        if(category1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        category1.setName(category.getName());
        categoryService.save(category1);
        return new ResponseEntity<>(category1,HttpStatus.OK);
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        Category category = categoryService.findById(id).get();
        if(category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        categoryService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
