package com.example.classonecomerceapp.controller;

import com.example.classonecomerceapp.dto.ProductsDto;
import com.example.classonecomerceapp.repository.ProductRepository;
import com.example.classonecomerceapp.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
    private final AdminService adminService;
    private final ProductRepository productRepository;

    @PostMapping("/postProduct")
    public ResponseEntity<ProductsDto> addProduct(@RequestBody ProductsDto productsDto){
        adminService.addProduct(productsDto);
        return new ResponseEntity<>(productsDto, HttpStatus.CREATED);
    }

    @PutMapping("/updateProduct{id}")
    public  ResponseEntity<ProductsDto> updateProduct(@RequestBody ProductsDto productsDto, @PathVariable Long id){
        adminService.updateProduct(productsDto, id);
        return new ResponseEntity<>(productsDto,HttpStatus.OK);
    }

    @DeleteMapping("/deleteProduct{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        productRepository.deleteById(id);
        return new ResponseEntity<>("Product deleted successfully",HttpStatus.OK);
    }
}
