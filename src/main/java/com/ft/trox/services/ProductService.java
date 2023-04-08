package com.ft.trox.services;

import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.ft.trox.models.Product;
import com.ft.trox.repositories.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Page<Product> pageAll(Pageable pageable) {
        Page<Product> page = productRepository.findAll(pageable);
        return page;
    }

    public Optional<Product> findById(UUID id) {
        return productRepository.findById(id);
    }

    @Transactional
    public void delete(Product product) {
        productRepository.delete(product);
    }
}
