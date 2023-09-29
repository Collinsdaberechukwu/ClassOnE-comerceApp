//package com.example.classonecomerceapp.exception;
//
//import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//public class GlobalExceptionHandler{
//    @ExceptionHandler(ResourceNotFoundException.class);
//    @ResponseStatus(HttpStatus.NOT_FOUND);
//
//    public ResponseEntity<String> HandleResourceNotFoundException(ResourceNotFoundException exception){
//        return  new ResponseEntity<>((exception.getMessage()), HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler(BadRequestException.class);
//}
