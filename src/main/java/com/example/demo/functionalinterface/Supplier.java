package com.example.demo.functionalinterface;

@FunctionalInterface
public interface Supplier {
    int get();
}

class SupplierInterfaceExa {
    public static void main(String[] args) {
        Supplier supplier = () -> 10;
        System.out.println(supplier.get());

    }
}