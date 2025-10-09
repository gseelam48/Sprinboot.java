package com.example.demo.controller;

import com.example.demo.dto.DoctorDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Doctor;
import com.example.demo.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

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
    @GetMapping("/{id}")
    public ResponseEntity<DoctorDto> getDoctor(@PathVariable Long id){
        DoctorDto doctor = doctorService.getDoctorById(id);
              return ResponseEntity.ok(doctor);
    }
    @PutMapping("/{id}")
    public ResponseEntity<DoctorDto> updateDoctor(@PathVariable Long id, @RequestBody DoctorDto doctorDto) {
        DoctorDto updatedStudent = doctorService.updateDoctor(id, doctorDto);
        return ResponseEntity.ok(updatedStudent);

}
}
