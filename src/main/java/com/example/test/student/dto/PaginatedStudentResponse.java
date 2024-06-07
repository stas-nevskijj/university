package com.example.test.student.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedStudentResponse {

    private Collection<StudentResponse> students;

    private long totalPages;

    private long totalElements;

    private long number;
}
