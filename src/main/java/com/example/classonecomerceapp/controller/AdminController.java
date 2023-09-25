package com.example.classonecomerceapp.controller;

import com.example.classonecomerceapp.dto.ProductsDto;
import com.example.classonecomerceapp.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
    private final AdminService adminService;

    @PostMapping("/post")
    public ResponseEntity<ProductsDto> addProduct(@RequestBody ProductsDto productsDto){
        adminService.addProduct(productsDto);
        return new ResponseEntity<>(productsDto, HttpStatus.CREATED);
    }
}
