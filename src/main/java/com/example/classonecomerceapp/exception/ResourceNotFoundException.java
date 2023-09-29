package com.example.classonecomerceapp.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ResourceNotFoundException extends Throwable{
    private String message;

    public ResourceNotFoundException(String message, HttpStatus httpStatus){
        this.message = message;
    }
}
