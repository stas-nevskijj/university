package com.example.test.student.service.impl;

import com.example.test.student.dto.PaginatedStudentSearchParam;
import com.example.test.student.dto.StudentCreateParam;
import com.example.test.student.dto.converter.StudentConverter;
import com.example.test.student.repository.StudentRepository;
import com.example.test.student.repository.entity.StudentEntity;
import com.example.test.student.repository.spec.StudentSpecMaker;
import com.example.test.student.service.StudentService;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final EntityManager entityManager;

    private final StudentRepository studentRepository;

    private final StudentConverter studentConverter;


    @Override
    @Transactional(readOnly = true)
    public Page<StudentEntity> findAllStudents(PaginatedStudentSearchParam filter) {

        var spec = StudentSpecMaker.makeSpec(filter);
        var pageRequest = PageRequest.of(
                filter.getPageNumber(), filter.getPageSize()
        );
        return studentRepository.findAll(spec, pageRequest);
    }

    @Override
    @Transactional(readOnly = true)
    public List<StudentEntity> findAllStudentsByCriteria() {
        var session = entityManager.unwrap(Session.class);
        var criteriaBuilder = session.getCriteriaBuilder();
        var criteriaQuery = criteriaBuilder.createQuery(StudentEntity.class);
        var root = criteriaQuery.from(StudentEntity.class);
        criteriaQuery.select(root).where(criteriaBuilder.like(root.get("firstName"), "%ан%"));

        var query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void registerStudent(StudentCreateParam createParam) {
        var studentEntity = studentConverter.toEntity(createParam);
        studentRepository.save(studentEntity);
    }
}
