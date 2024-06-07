package com.example.test.student.dto.converter;

import com.example.test.student.dto.StudentCreateParam;
import com.example.test.student.repository.entity.StudentEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentConverter {

    private final ModelMapper modelMapper;


    public StudentEntity toEntity(StudentCreateParam createParam) {
        return modelMapper.map(createParam, StudentEntity.class);
    }
}
