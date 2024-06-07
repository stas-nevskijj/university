package com.example.test.student.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentCreateParam {

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    private String email;

    private String phone;
}
