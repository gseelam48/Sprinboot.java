package com.example.demo.sreams;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
public class Transaction {

    String date;
    int amount;


}