package com.example.demo.entity;

public class MarkerInterfaceEx {
    public static void main(String[] args) {
        Employe emp = new Employe(1, "John");
        Product prod = new Product(101, "Laptop");

        Database.save(emp);
        Database.save(prod);
    }
}

interface Saveable {
}

class Employe implements Saveable {
    int id;
    String name;

    Employe(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Product {
    int code;
    String description;

    Product(int code, String description) {
        this.code = code;
        this.description = description;
    }
}

class Database {
    public static void save(Object obj) {
        if (obj instanceof Saveable) {
            System.out.println("✅ " + obj.getClass().getSimpleName() + " saved to database.");
        } else {
            System.out.println("❌ " + obj.getClass().getSimpleName() + " cannot be saved (not Saveable).");
        }
    }
}

