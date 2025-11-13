package com.example.demo.entity;

import com.example.demo.repository.StudentRepository;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Student123")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String address;
    private Long phoneNumber;
    private String email;
    private String password;

}
