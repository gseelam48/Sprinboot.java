package com.example.demo.service.impl;


import com.example.demo.dto.DoctorDto;
import com.example.demo.entity.Doctor;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.service.DoctorService;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService {


    private final DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    private DoctorDto mapToDto(Doctor doctor) {
        return new DoctorDto(doctor.getId(),doctor.getDesignation(), doctor.getPatientsType());
    }

    private Doctor mapToEntity(DoctorDto dto) {
        return new Doctor(dto.getDesignation(), dto.getPatientsType());
    }

    public DoctorDto createDoctor(DoctorDto dto) {
        Doctor doctor = mapToEntity(dto);
        Doctor saved = doctorRepository.save(doctor);
        return mapToDto(saved);
    }
}
