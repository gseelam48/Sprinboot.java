package com.example.demo.controller;

import com.example.demo.entity.Patient;
import com.example.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientRepository patientRepository;

    @PostMapping("/savePatient")
    public String savePatient(@RequestBody Patient patient) {
        patientRepository.save(patient);
        return "Patient saved Successfully";
    }

    @GetMapping
    public Iterable<Patient> getPatient() {
        return patientRepository.findAll();
    }

    @GetMapping("/getById")
    public Patient getPatientById(@RequestParam Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @GetMapping("/getByName")
    public Patient getPatientByName(@RequestParam String name) {
        return patientRepository.findByName(name);
    }

    @PutMapping("/updatePatient")
    public Patient updatePatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

    @DeleteMapping("/deleteById")
    public void deletePatient(@RequestParam Long id) {
        patientRepository.deleteById(id);
    }
}
