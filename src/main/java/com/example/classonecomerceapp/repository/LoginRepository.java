package com.example.classonecomerceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<UserRepository,Long> {
}
