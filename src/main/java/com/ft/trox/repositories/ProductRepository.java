package com.ft.trox.repositories;

import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ft.trox.models.Product;

public interface ProductRepository extends JpaRepository<Product, UUID>{

    Page<Product> findAll(Pageable pageable);
}
