package com.example.classonecomerceapp.service;

import com.example.classonecomerceapp.dto.ProductsDto;
import com.example.classonecomerceapp.dto.ResponseData;
import com.example.classonecomerceapp.model.Product;
import com.example.classonecomerceapp.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;


    public ProductsDto getProductById(Long id){
        Product product = productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product not found try other products"));
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    public ResponseData getAllProductById(Pageable pageable){
        Page<Product> page = productRepository.findAll((org.springframework.data.domain.Pageable) pageable);
        List<ProductsDto> productDTOList = converTodoList(page.getContent());
        ResponseData responseData = new ResponseData();
        responseData.setResponse(productDTOList);
        responseData.setFirst(page.isFirst());
        responseData.setLast(page.isLast());
        responseData.setPageNo(page.getNumber());
        responseData.setPageSize(page.getSize());
        responseData.setTotalItems(page.getNumberOfElements());
        log.info("Response Data {} ",responseData);
        return responseData;
    }

    private List<ProductsDto> converTodoList(List<Product> content) {
        return content.stream().map(this::map2ProductDTO).collect(Collectors.toList());
    }
    ProductsDto map2ProductDTO(Product product){
        ProductsDto productsDto = new ProductsDto();
        productsDto.setAmount(product.getAmount());
        productsDto.setName(product.getName());
        productsDto.setDescription(product.getDescription());
        return productsDto;
    }

}
