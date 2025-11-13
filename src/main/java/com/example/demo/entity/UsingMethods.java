package com.example.demo.entity;

public class UsingMethods {
    public static void main(String[] args) {

    }
}
class Animal {
    int addTwoNumbers(int a , int b){
        return a+b;
    }
}
class Dog extends Animal{
    @Override
    int addTwoNumbers(int a , int b){
        return a+b;
    }
}