package com.example.demo.repository;

import com.example.demo.entity.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends CrudRepository <Patient,Long>{
    Patient findByName(String name);
}
