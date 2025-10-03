package com.example.demo.controller;

import com.example.demo.dto.StudentDto;
import com.example.demo.service.StudentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Tag(name = "Student CRUD API", description = "API for managing users")
@RestController
@RequestMapping("/api/students")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/searchStudents1")
    public ResponseEntity<List<StudentDto>> searchStudents1(@RequestBody StudentDto studentDto) {
        List<StudentDto> students = studentService.searchStudents1(studentDto);
        return ResponseEntity.ok(students);
    }

    // CREATE Student
    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody @Valid StudentDto studentDto) {
        //System.out.println(studentDto);
        logger.info("creating student");
        StudentDto savedStudent = studentService.createStudent(studentDto);
        // Return 201 Created with Location header
        logger.info("student created successfully with id " + savedStudent.getId());
        return ResponseEntity.created(URI.create("/api/students/" + savedStudent.getId())).body(savedStudent);
    }

    // GET Student by ID
    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable Long id) {
        logger.info("Student information");
        StudentDto student = studentService.getStudentById(id);
        logger.info("Student information with id "+student.getId());
        return ResponseEntity.ok(student); // 200 OK
    }

    // GET All Students
    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        List<StudentDto> students = studentService.getAllStudents();
        logger.info(" Student size " + students.size());
        return ResponseEntity.ok(students); // 200 OK
    }

    // UPDATE Student
    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id, @RequestBody StudentDto studentDto) {
        StudentDto updatedStudent = studentService.updateStudent(id, studentDto);
        logger.info(" Student updated successfully with id " + updatedStudent.getId());

        return ResponseEntity.ok(updatedStudent); // 200 OK
    }

    // DELETE Student
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }

    // getStudentsOrderByAddress
    @GetMapping("/getStudentsOrderByAddress")
    public ResponseEntity<List<StudentDto>> getStudentsOrderByAddress() {
        List<StudentDto> students = studentService.getStudentsOrderByAddress();
        return ResponseEntity.ok(students); // 200 OK
    }

    //  getStudentsOrderByName
    @GetMapping("/getStudentsOrderByName")
    public ResponseEntity<List<StudentDto>> getStudentsOrderByName() {
        List<StudentDto> students = studentService.getStudentsOrderByName();
        return ResponseEntity.ok(students); // 200 OK
    }

    @GetMapping("/getStudentsByName/{name}")
    public ResponseEntity<List<StudentDto>> getStudentsByName(@PathVariable String name) {
        List<StudentDto> students = studentService.getStudentsByName(name);
        return ResponseEntity.ok(students);
    }

    @PostMapping("/searchStudents")
    public ResponseEntity<List<StudentDto>> searchStudents(@RequestBody StudentDto studentDto) {
        List<StudentDto> students = studentService.searchStudents(studentDto);
        return ResponseEntity.ok(students);
    }
}
/*@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @PostMapping("/saveStudent")
    public ResponseEntity saveStudent(@RequestBody StudentDto studentDto) {
        Student student = new Student();
        student.setName(studentDto.getName());
        student.setAddress(studentDto.getAddress());
        studentRepository.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body("Student created successfully");
    }

    @GetMapping("/getStudents")
    public Iterable<Student> getStudent() {
        return studentRepository.findAll();
    }

    @GetMapping("/getById")
    public Student getStudentById(@RequestParam Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @GetMapping("/getByName")
    public Student getStudentByName(@RequestParam String name) {
        return studentRepository.findByName(name);
    }

    @DeleteMapping("/getById")
    public ResponseEntity deleteStudentById(@RequestParam Long id) {
        studentRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/update")
    public Student updateStudentData(@RequestBody Student student) {
        return studentRepository.save(student);
    }
}*/


