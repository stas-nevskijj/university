package com.example.test.student.service.impl;

import com.example.test.student.dto.PaginatedStudentResponse;
import com.example.test.student.dto.PaginatedStudentSearchParam;
import com.example.test.student.dto.StudentCreateParam;
import com.example.test.student.dto.StudentResponse;
import com.example.test.student.dto.converter.StudentWebConverter;
import com.example.test.student.service.StudentService;
import com.example.test.student.service.StudentWebFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentWebFacadeImpl implements StudentWebFacade {

    private final StudentService studentService;
    private final StudentWebConverter studentWebConverter;

    @Override
    @Transactional(readOnly = true)
    public PaginatedStudentResponse findAllStudents(PaginatedStudentSearchParam filter) {
        var students = studentService.findAllStudents(filter);
        return studentWebConverter.toPaginatedResponse(students);
    }

    @Override
    public List<StudentResponse> findAllStudentsByCriteria() {
        var students = studentService.findAllStudentsByCriteria();
        return studentWebConverter.toResponses(students);
    }

    @Override
    @Transactional
    public void registerStudent(StudentCreateParam createParam) {
        studentService.registerStudent(createParam);
    }


}
