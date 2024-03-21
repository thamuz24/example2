package com.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "productcategory")
public class ProductCategory {
    @Id
    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @Id
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public ProductCategory() {
    }

    public ProductCategory(Product product, Category category) {
        this.product = product;
        this.category = category;
    }
}
