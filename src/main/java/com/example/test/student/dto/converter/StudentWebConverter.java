package com.example.test.student.dto.converter;

import com.example.test.student.dto.PaginatedStudentResponse;
import com.example.test.student.dto.StudentResponse;
import com.example.test.student.repository.entity.StudentEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StudentWebConverter {

    private final ModelMapper modelMapper;

    public PaginatedStudentResponse toPaginatedResponse(Page<StudentEntity> page) {
        var pageResponse = new PaginatedStudentResponse();
        modelMapper.map(page, pageResponse);
        pageResponse.setStudents(toResponses(page.getContent()));
        return pageResponse;
    }

    public List<StudentResponse> toResponses(List<StudentEntity> students) {
        return students.stream().map(this::toResponse).toList();
    }

    private StudentResponse toResponse(StudentEntity student) {
        return modelMapper.map(student, StudentResponse.class);
    }

}
