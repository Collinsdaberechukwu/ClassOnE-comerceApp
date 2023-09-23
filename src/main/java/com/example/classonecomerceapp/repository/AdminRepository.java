package com.example.classonecomerceapp.repository;

import com.example.classonecomerceapp.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Long> {
}
