package com.example.test.student.controller;

import com.example.test.student.dto.PaginatedStudentResponse;
import com.example.test.student.dto.PaginatedStudentSearchParam;
import com.example.test.student.dto.StudentCreateParam;
import com.example.test.student.dto.StudentResponse;
import com.example.test.student.service.StudentWebFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.test.student.controller.StudentController.BASE_PATH;

@RestController
@RequestMapping(BASE_PATH)
@RequiredArgsConstructor
public class StudentController {

    private final StudentWebFacade studentWebFacade;

    static final String BASE_PATH = "/students";

    @GetMapping
    public PaginatedStudentResponse findAllStudents(PaginatedStudentSearchParam filter) {
        return studentWebFacade.findAllStudents(filter);
    }

    @GetMapping("/criteria")
    public List<StudentResponse> findAllStudentsByCriteria() {
        return studentWebFacade.findAllStudentsByCriteria();
    }

    @PostMapping
    public void registerStudent(@RequestBody StudentCreateParam createParam) {
        studentWebFacade.registerStudent(createParam);
    }
}
