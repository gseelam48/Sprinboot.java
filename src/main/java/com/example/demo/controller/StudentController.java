package com.example.demo.controller;

import com.example.demo.repository.StudentRepository;
import com.example.demo.request.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @PostMapping("/saveStudent")
    public String saveStudent(@RequestBody Student student) {
        studentRepository.save(student);
        return "Student Saved Successfully";
    }

    @GetMapping("/getStudents")
    public Iterable<Student> getStudent() {
        return studentRepository.findAll();
    }

    @GetMapping("/getById")
    public Student getStudentById(@RequestParam Long id){
        return studentRepository.findById(id).orElse(null);
    }

    @GetMapping("/getByName")
    public Student getStudentByName(@RequestParam String name){
        return studentRepository.findByName(name);
    }
    @DeleteMapping ("/getById")
    public void deleteStudentById(@RequestParam Long id) {
        studentRepository.deleteById(id);

    }
    @PutMapping ("/update")
    public Student updateStudentData(@RequestBody Student student) {
        return studentRepository.save(student);
    }
}


