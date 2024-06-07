package com.example.test.student.service;

import com.example.test.student.dto.PaginatedStudentResponse;
import com.example.test.student.dto.PaginatedStudentSearchParam;
import com.example.test.student.dto.StudentCreateParam;
import com.example.test.student.dto.StudentResponse;

import java.util.List;

public interface StudentWebFacade {

    PaginatedStudentResponse findAllStudents(PaginatedStudentSearchParam filter);

    List<StudentResponse> findAllStudentsByCriteria();

    void registerStudent(StudentCreateParam createParam);

}
