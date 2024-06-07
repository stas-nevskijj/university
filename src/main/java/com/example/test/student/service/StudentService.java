package com.example.test.student.service;

import com.example.test.student.dto.PaginatedStudentSearchParam;
import com.example.test.student.dto.StudentCreateParam;
import com.example.test.student.repository.entity.StudentEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {

    Page<StudentEntity> findAllStudents(PaginatedStudentSearchParam filter);

    List<StudentEntity> findAllStudentsByCriteria();

    void registerStudent(StudentCreateParam createParam);

}
