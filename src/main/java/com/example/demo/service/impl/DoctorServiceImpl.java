package com.example.demo.service.impl;


import com.example.demo.dto.DoctorDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Doctor;
import com.example.demo.entity.Student;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.service.DoctorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {


    private final DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    private DoctorDto mapToDto(Doctor doctor) {
        return new DoctorDto(doctor.getId(), doctor.getDesignation(), doctor.getPatientsType());
    }

    private Doctor mapToEntity(DoctorDto dto) {
        return new Doctor(dto.getDesignation(), dto.getPatientsType());
    }

    public DoctorDto createDoctor(DoctorDto dto) {
        Doctor doctor = mapToEntity(dto);
        Doctor saved = doctorRepository.save(doctor);
        return mapToDto(saved);
    }

    @Override
    public DoctorDto getDoctorById(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("student not found"));
        return mapToDto(doctor);
    }

    @Override
    public DoctorDto updateDoctor(Long id, DoctorDto doctorDto) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        doctor.setDesignation(doctorDto.getDesignation());
        doctor.setPatientsType(doctorDto.getPatientsType());
        Doctor updated = doctorRepository.save(doctor);
        return mapToDto(updated);
    }

}
