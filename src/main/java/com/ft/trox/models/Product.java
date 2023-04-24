package com.ft.trox.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.ft.trox.dtos.ProductDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product implements Serializable {
    
    private static final Long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 70)
    private String title;

    @Column(nullable = false, length = 500)
    private String description;
    
    @Column(nullable = false, length = 50)
    private String category;
    
    @Column(nullable = false)
    private BigDecimal price;
    
    @Column(nullable = false, length = 70)
    private String user;
    
    @Column(nullable = false)
    private LocalDateTime createdAt;

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }
    
    public BigDecimal getPrice() {
        return price;
    }
    
    public String getUser() {
        return user;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Deprecated
    protected Product() {}

    public Product(String title, String description, String category, BigDecimal price, String user) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
        this.user = user;
        this.createdAt = LocalDateTime.now();
    }

    public Product(ProductDto dto) {
        this.title = dto.title();
        this.description = dto.description();
        this.category = dto.category();
        this.price = dto.price();
        this.user = dto.user();
        this.createdAt = LocalDateTime.now();
    }

    public Product update(String title, String description, String category, BigDecimal price, String user) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
        this.user = user;
        return this;
    }
}
