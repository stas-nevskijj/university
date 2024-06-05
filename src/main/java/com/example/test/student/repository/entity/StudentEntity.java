package com.example.test.student.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
@Table(name = "students")
@Entity
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    @Column(unique = true)
    private String email;

    private String phone;

    @Transient
    private int age;

    public int getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }
}
