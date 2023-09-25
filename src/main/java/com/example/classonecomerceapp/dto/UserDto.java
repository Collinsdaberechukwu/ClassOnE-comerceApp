package com.example.classonecomerceapp.dto;

import com.example.classonecomerceapp.Enum.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String phoneNumber;
    private Roles category;
    private String password;
}
