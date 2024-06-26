package com.example.test.student.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentResponse {

    private int id;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    private String email;

    private String phone;

    private int age;
}
