package com.example.demo.functionalinterface;

@FunctionalInterface
public interface FunctionalInterfaceEx1 {
    int multi(int a, int b);
}

class FunctionalInterface1 {
    public static void main(String[] args) {
        FunctionalInterfaceEx1 example2 = (a , b) -> a * b;
        System.out.println(example2.multi(3,4));
    }
}