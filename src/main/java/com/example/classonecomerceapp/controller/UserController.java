package com.example.classonecomerceapp.controller;

import com.example.classonecomerceapp.dto.SignUp;
import com.example.classonecomerceapp.model.Users;
import com.example.classonecomerceapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/new")
public class UserController {
    private final UserService userService;

    @PostMapping("/postNew")
    public ResponseEntity<SignUp> createUser(@RequestBody SignUp signUp){
        userService.createUser(signUp);
        return new ResponseEntity<>(signUp, HttpStatus.CREATED);
    }
}
