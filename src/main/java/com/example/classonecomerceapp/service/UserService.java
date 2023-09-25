package com.example.classonecomerceapp.service;

import com.example.classonecomerceapp.dto.Login;
import com.example.classonecomerceapp.dto.SignUp;
import com.example.classonecomerceapp.dto.UserDto;
import com.example.classonecomerceapp.model.Users;
import com.example.classonecomerceapp.repository.LoginRepository;
import com.example.classonecomerceapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final LoginRepository loginRepository;
    public ResponseEntity<Users>  createUser(SignUp signUp) {
        Users newUser = new Users();
        newUser.setFirstName(signUp.getFirstName());
        newUser.setLastName(signUp.getLastName());
        newUser.setUsername(signUp.getUsername());
        newUser.setPassword(signUp.getPassword());
        newUser.setPhoneNumber(signUp.getPhoneNumber());
        newUser.setEmail(signUp.getEmail());
        newUser.setCategory(signUp.getCategory());

        Users savedUser = userRepository.save(newUser);
        return new ResponseEntity<>(savedUser,HttpStatus.CREATED);

    }
     public ResponseEntity<Users> loginUser(UserDto userDto) {
         Users userLogger = new Users();
         userLogger.setEmail(userDto.getEmail());
         userLogger.setPassword(userDto.getPassword());
         Users loggedUser = userRepository.save(userLogger);
         return new ResponseEntity<>(loggedUser, HttpStatus.OK);
     }
}
