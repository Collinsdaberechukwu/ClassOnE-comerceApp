package com.example.classonecomerceapp.service;

import com.example.classonecomerceapp.dto.ProductsDto;
import com.example.classonecomerceapp.dto.SignUp;
import com.example.classonecomerceapp.model.Admin;
import com.example.classonecomerceapp.model.Product;
import com.example.classonecomerceapp.model.Users;
import com.example.classonecomerceapp.repository.AdminRepository;
import com.example.classonecomerceapp.repository.ProductRepository;
import com.example.classonecomerceapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService{
    private final ProductRepository productRepository;
    private final AdminRepository adminRepository;
    private final UserRepository userRepository;


    Product createProduct(ProductsDto productsDto) {
           Product newProduct = new Product();
           newProduct.setName(productsDto.getName());
           newProduct.setAmount(productsDto.getAmount());
           newProduct.setDescription(productsDto.getDescription());

//           we will work on line 27
           return productRepository.save(newProduct);
    }


}
