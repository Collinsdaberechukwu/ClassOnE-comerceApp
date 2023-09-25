package com.example.classonecomerceapp.model;

import com.example.classonecomerceapp.Enum.Roles;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "admin_table")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String firstName;
    private String lastName;
    private String username;
    private String email;


    @CreationTimestamp
    private Date created;
    @UpdateTimestamp
    private Date updated;

}