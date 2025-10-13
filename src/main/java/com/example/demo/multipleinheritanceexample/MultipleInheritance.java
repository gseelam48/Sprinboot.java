package com.example.demo.multipleinheritanceexample;

public class MultipleInheritance {
    public static void main(String[] args) {

        Bike bike = new Bike();
        bike.start();

    }
}

class Bike implements Vehicle, Vehicle1 {

    @Override
    public void start() {
        System.out.println(" bike Starts ");
        Vehicle.super.start();
        Vehicle1.super.start();
    }
}


interface Vehicle {
    default void start() {
        System.out.println(" vehicle starts ");
    }
}

interface Vehicle1 {
    default void start() {
        System.out.println("vehicle1 stats");
    }
}