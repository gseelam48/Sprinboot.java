package com.example.demo.service;

import com.example.demo.dto.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto createStudent(StudentDto studentDto);

    StudentDto getStudentById(Long Id);

    List<StudentDto> getAllStudents();

    List<StudentDto> getStudentsOrderByAddress();

    List<StudentDto> getStudentsOrderByName();

    List<StudentDto> getStudentsByName(String name);

    List<StudentDto> searchStudents(StudentDto studentDto);

    List<StudentDto> searchStudents1(StudentDto studentDto);


    StudentDto updateStudent(Long Id, StudentDto studentDto);

    void deleteStudent(Long id);

}

