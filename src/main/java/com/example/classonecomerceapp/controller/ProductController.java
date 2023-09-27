package com.example.classonecomerceapp.controller;


import com.example.classonecomerceapp.dto.ProductsDto;
import com.example.classonecomerceapp.dto.ResponseData;
import com.example.classonecomerceapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("getProductById{id}")
    public ResponseEntity<ProductsDto> getProductById(@PathVariable Long id){
       ProductsDto foundProduct = productService.getProductById(id);
        if (foundProduct == null){
            throw new RuntimeException("Product not found or not available");
        }
        return new ResponseEntity<>( foundProduct, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<ResponseData> getAllProduct(@RequestParam (defaultValue = "1")int pageNo, @RequestParam (defaultValue = "5")int pageSize) throws RuntimeException{
        Pageable pageable = (Pageable) PageRequest.of(pageNo-1,pageSize);
        ResponseData responseData = productService.getAllProductById(pageable);
        return  ResponseEntity.ok(responseData);
    }

}
