package com.example.demo.service.impl;

import com.example.demo.service.Animal;
import org.springframework.stereotype.Service;

@Service
public class Cat implements Animal {

    @Override
    public void eat() {
        System.out.println(" cat is eating ");
    }

    @Override
    public void bark() {
        System.out.println("cat is meowing");
    }
}
