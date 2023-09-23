package com.example.classonecomerceapp.service;

import com.example.classonecomerceapp.dto.SignUp;
import com.example.classonecomerceapp.model.Users;
import com.example.classonecomerceapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    Users createUser(SignUp signUp) {
        Users newUser = new Users();
        newUser.setFirstName(signUp.getFirstName());
        newUser.setLastName(signUp.getLastName());
        newUser.setUsername(signUp.getUsername());
        newUser.setPassword(signUp.getPassword());
        newUser.setPhoneNumber(signUp.getPhoneNumber());
        newUser.setEmail(signUp.getEmail());
        newUser.setCategory(signUp.getCategory());

        return userRepository.save(newUser);
    }
}
