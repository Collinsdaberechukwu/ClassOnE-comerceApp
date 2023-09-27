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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService{
    private final ProductRepository productRepository;
    private final AdminRepository adminRepository;
    private final UserRepository userRepository;

    public ResponseEntity<Product> addProduct(ProductsDto  productsDto){
        Product newProduct = new Product();
        newProduct.setName(productsDto.getName());
        newProduct.setDescription(productsDto.getDescription());
        newProduct.setAmount(productsDto.getAmount());

        Product addedProduct = productRepository.save(newProduct);
        return  new ResponseEntity<>(addedProduct, HttpStatus.CREATED);
    }

    public ResponseEntity<Product> updateProduct(ProductsDto productsDto,Long id){
        Product product = productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product not found"));
    product.setAmount(productsDto.getAmount());
     product.setName(productsDto.getName());
       product.setDescription(productsDto.getDescription());

        Product savedUpdate = productRepository.save(product);
        return new ResponseEntity<>(savedUpdate,HttpStatus.CREATED);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    public ResponseEntity<Product> getProduct( Long id){
        Product gettingProduct = productRepository.findById(id).get();
        return new ResponseEntity<>(gettingProduct,HttpStatus.OK);
    }


}
