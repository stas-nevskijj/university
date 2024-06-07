package com.example.test.student.dto;

import com.example.test.common.dto.PaginatedFilterParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PaginatedStudentSearchParam extends PaginatedFilterParam {

    private Set<Long> studentIds = new HashSet<>();

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private LocalDate dateOfBirth;

    private String sortBy;
}
