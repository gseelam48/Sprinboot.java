package com.example.demo.service.impl;

import com.example.demo.service.Animal;
import org.springframework.stereotype.Service;

@Service
public class Dog implements Animal {

      @Override
    public void bark() {
          System.out.println(" dog is barking ");
    }
    public void eat(){
        System.out.println(" dog is eating ");
    }
}
