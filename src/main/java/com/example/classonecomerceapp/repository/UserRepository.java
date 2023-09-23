package com.example.classonecomerceapp.repository;

import com.example.classonecomerceapp.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Long> {
}
