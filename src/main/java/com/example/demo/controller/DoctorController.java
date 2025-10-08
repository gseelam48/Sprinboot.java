package com.example.demo.controller;

import com.example.demo.dto.DoctorDto;
import com.example.demo.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/Doctor")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public ResponseEntity<DoctorDto> createDoctor(@RequestBody @Valid DoctorDto doctorDto) {
        DoctorDto savedDoctor = doctorService.createDoctor(doctorDto);
        return ResponseEntity.created(URI.create("api/Doctor" + savedDoctor.getId())).body(savedDoctor);

    }
}
