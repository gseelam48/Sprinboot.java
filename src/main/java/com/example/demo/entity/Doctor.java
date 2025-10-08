package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "doctor1")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String designation;
    String patientsType;

    public Doctor(){

    }
    public Doctor(String designation, String patientsCount) {
        this.designation = designation;
        this.patientsType = patientsCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getPatientsType() {
        return patientsType;
    }

    public void setPatientsType(String patientsType) {
        this.patientsType = patientsType;
    }
}
