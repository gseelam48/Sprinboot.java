package com.example.demo.entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {
    public static void main(String[] args) {
        String email = "testuser@gmail.com";
        String regExpression = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern p = Pattern.compile(regExpression);
        System.out.println(p.matcher(email).matches());

        String regExpression1 = "^[0-9]{10}+$";
        String phoneNumber = "9848112282";
        Pattern p1 = Pattern.compile(regExpression1);
        System.out.println(p1.matcher(phoneNumber).matches());

        String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=])(?=\\S+$).{8,20}$";
       // String PASSWORD_REGE1 = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=])(?=\\S+$).{8,20}$";
        Pattern pattern = Pattern.compile(PASSWORD_REGEX );
      //  Pattern pattern1 = Pattern.compile(PASSWORD_REGE1 );
        String password = "Strong@123";
        Matcher matcher = pattern.matcher(password);
       // Matcher matcher1 = pattern1.matcher(password);
        System.out.println(matcher.matches());
      //  System.out.println(matcher1.matches());

    }
}
