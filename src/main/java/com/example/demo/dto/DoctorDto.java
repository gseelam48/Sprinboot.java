package com.example.demo.dto;

public class DoctorDto {


    Long id;
    String designation;
    String patientsType;

   public DoctorDto(){

  }

    public DoctorDto(Long id, String designation, String patientsType) {
        this.id = id;
        this.designation = designation;
        this.patientsType = patientsType;
    }

    public DoctorDto(String designation, String patientsType) {
        this.designation = designation;
        this.patientsType = patientsType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPatientsType() {
        return patientsType;
    }

    public void setPatientsType(String patientsType) {
        this.patientsType = patientsType;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "DoctorDto{" +
                "id=" + id +
                ", designation='" + designation + '\'' +
                ", patientsType='" + patientsType + '\'' +
                '}';
    }
}
