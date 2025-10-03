package com.example.demo.service.impl;

import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    private StudentDto mapToDto(Student student) {
        StudentDto studentDto = new StudentDto();
        // studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setAddress(student.getAddress());
        studentDto.setPhoneNumber(student.getPhoneNumber());
        studentDto.setEmail(student.getEmail());
        //  return studentDto;
        return new StudentDto(student.getId(), student.getName(), student.getAddress(), student.getPhoneNumber(), student.getEmail());
    }

    private Student mapToEntity(StudentDto dto) {
        System.out.println("mapToEntity" + dto);
        Student student = new Student();
        student.setName(dto.getName());
        student.setAddress(dto.getAddress());
        student.setPhoneNumber(dto.getPhoneNumber());
        student.setEmail(dto.getEmail());
        return student;
        //   return new Student(dto.getName(), dto.getAddress());
    }

    @Override
    public List<StudentDto> searchStudents1(StudentDto studentDto) {
        Pageable pageable = PageRequest.of(studentDto.getPage(),studentDto.getSize(), Sort.by(studentDto.getSortBy()));
        return studentRepository.findAll(pageable)
                .stream().map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        System.out.println("------" + studentDto);
        Student student = mapToEntity(studentDto);
        Student saved = studentRepository.save(student);
        return mapToDto(saved);
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        return mapToDto(student);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        return studentRepository.findAll()
                .stream().map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentDto> getStudentsOrderByAddress() {
        return studentRepository.getStudentsOrderByAddress()
                .stream().map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto updateStudent(Long id, StudentDto studentDto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setName(studentDto.getName());
        student.setAddress(studentDto.getAddress());
        Student updated = studentRepository.save(student);
        return mapToDto(updated);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<StudentDto> getStudentsOrderByName() {
        return studentRepository.getStudentsOrderByName()
                .stream().map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentDto> getStudentsByName(String name) {
        return studentRepository.getStudentsByName(name)
                .stream().map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentDto> searchStudents(StudentDto studentDto) {
        return studentRepository.searchStudents(studentDto)
                .stream().map(this::mapToDto)
                .collect(Collectors.toList());
    }
}


