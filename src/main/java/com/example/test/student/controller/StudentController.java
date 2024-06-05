package com.example.test.student.controller;

import com.example.test.student.dto.StudentResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping()
public class StudentController {

    private static final String BASE_PATH = "/students";

    public List<StudentResponse> findAllStudents() {
        return null;
    }
}
