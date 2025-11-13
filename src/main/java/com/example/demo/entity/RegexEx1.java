package com.example.demo.entity;

import java.util.regex.*;

public class RegexEx1 {
    public static void main(String[] args) {

        String PASSWORD_REGEX = "^(?=.[0-9])(?=.[a-z])(?=.[A-Z])(?=.[!@#$%^&+=])(?=\\S+$).{8,20}$";
        Pattern pattern = Pattern.compile(PASSWORD_REGEX);
        String password = "StrongP@ss1";
        Matcher matcher = pattern.matcher(password);
        System.out.println(matcher.matches());
    }
}