package com.example.demo.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class StudentDto {
    int page = 0;
    int size = 5;
    String sortBy = "id";
    private long id;
    @NotBlank(message = "name cannot be blank")
    @Size(min = 5, max = 10, message = "name must be between 5 to 10 char")
    private String name;
    @NotEmpty(message = "Address cannot be empty")
    @Pattern(regexp = "^[a-zA-z0-9\\s,.-]*$", message = "Address contains invalid char")
    private String address;
    @Digits(integer = 10, fraction = 0, message = "phone number must be numeric and up to 10 digits")
    @Positive(message = "phone number must be positive")
    private Long phoneNumber;
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Invalid email format")
    @Size(max = 50, message = "Email cannot exceed 50 characters")
    private String email;
    private String password;


    public StudentDto(long id, String name, String address, Long phoneNumber, String email, String password) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;

    }

    public StudentDto() {

    }
}
