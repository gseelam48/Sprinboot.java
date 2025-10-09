package com.example.demo.service;


import com.example.demo.dto.DoctorDto;

import java.util.List;

public interface DoctorService {
    DoctorDto createDoctor( DoctorDto doctorDto);

    DoctorDto getDoctorById(Long id);

    DoctorDto updateDoctor(Long id, DoctorDto doctorDto);
}