package com.ft.trox.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

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
    public void setId(UUID id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public void setPrice(String price) {
        this.price = new BigDecimal(price);
    }
    public void setUser(String user) {
        this.user = user;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
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
