package com.example.demo.repository;

import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
//public interface StudentRepository extends CrudRepository<Student,Long> {
public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByName(String name);

    @Query("SELECT s FROM Student s ORDER BY s.address")
    List<Student> getStudentsOrderByAddress();

    @Query("SELECT s FROM Student s ORDER BY s.name")
    List<Student> getStudentsOrderByName();
    @Query("SELECT s FROM Student s where s.name = :name ")
    List<Student> getStudentsByName (@Param("name") String name);
   // @Query("SELECT s FROM Student s WHERE s.name = :#{#dto.name} AND s.address = :#{#dto.address}")
   @Query(" SELECT s FROM Student s " +
           "WHERE (:#{#dto.name} IS NULL OR :#{#dto.name} = '' OR s.name = :#{#dto.name}) " +
           "AND (:#{#dto.address} IS NULL OR :#{#dto.address} = '' OR s.address = :#{#dto.address}) " +
           "AND (:#{#dto.phoneNumber} IS NULL OR :#{#dto.phoneNumber} = '' OR s.phoneNumber = :#{#dto.phoneNumber}) " +
           "AND (:#{#dto.email} IS NULL OR :#{#dto.email} = '' OR s.email = :#{#dto.email})")
   List<Student> searchStudents(@Param("dto") StudentDto dto);


}
