package com.example.classonecomerceapp.repository;

import com.example.classonecomerceapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
