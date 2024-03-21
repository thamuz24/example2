package com.example.controller;

import com.example.model.Product;
import com.example.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<Iterable<Product>> showALlProduct() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        if (productService.findById(product.getProductId()) != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody Product product, @PathVariable Long id) {
        Product product1 = productService.findById(id).get();
        if (product1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        product1.setName(product.getName());
        productService.save(product1);
        return new ResponseEntity<>(product1, HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        Product product = productService.findById(id).get();
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/products/{min}/{max}")
    public ResponseEntity<Iterable<Product>> filterByPrice(@PathVariable Long min, @PathVariable Long max) {
        return new ResponseEntity<>(productService.findAllByPriceBetween(min, max), HttpStatus.OK);
    }

    @GetMapping("/products/desc")
    public ResponseEntity<Iterable<Product>> filterByQuantity() {
        return new ResponseEntity<>(productService.findByOrderByAmountDesc(),HttpStatus.OK);
    }
}
