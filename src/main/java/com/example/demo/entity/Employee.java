package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "Employee123")
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;
    double salary;
}