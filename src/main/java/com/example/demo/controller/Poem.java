package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class Poem {

    @GetMapping("/saidPoem")
    public String writePoem() {
        return "jhonney jhonney yes papa eating suger no papa telling lies no papa open your mouth hahaha...";
    }
}
