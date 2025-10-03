package com.example.demo.dto;

import jakarta.validation.constraints.*;

public class StudentDto {
    int page = 0;
    int size = 5;
    String sortBy = "id";
    long id;
    @NotBlank(message = "name cannot be blank")
    @Size(min = 5, max = 10, message = "name must be between 5 to 10 char")
    String name;
    @NotEmpty(message = "Address cannot be empty")
    @Pattern(regexp = "^[a-zA-z0-9\\s,.-]*$", message = "Address contains invalid char")
    String address;
    @Digits(integer = 10, fraction = 0, message = "phone number must be numeric and up to 10 digits")
    @Positive(message = "phone number must be positive")
    Long phoneNumber;
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Invalid email format")
    @Size(max = 50, message = "Email cannot exceed 50 characters")
    String email;


    @Override
    public String toString() {
        return "StudentDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                '}';
    }


    public StudentDto() {

    }


    public StudentDto(long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public StudentDto(long id, String name, String address, Long phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getId() {
        return id;
    }
}
