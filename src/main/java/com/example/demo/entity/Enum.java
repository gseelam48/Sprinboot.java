package com.example.demo.entity;

public class Enum {
    public static void main(String[] args) {
        enum Season {WINTER, SPRING, SUMMER, FALL}
        for (Season s : Season.values())
            System.out.println(s);

    }
}
