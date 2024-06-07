package com.example.test.student.repository.spec;

import com.example.test.student.dto.PaginatedStudentSearchParam;
import com.example.test.student.repository.entity.StudentEntity;
import com.example.test.student.repository.entity.StudentEntity_;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StudentSpecMaker {

    public static Specification<StudentEntity> makeSpec(PaginatedStudentSearchParam filter) {
        var resultSpec = sortingFilter(filter);
        return resultSpec;
    }

    private static Specification<StudentEntity> sortingFilter(PaginatedStudentSearchParam filter) {
        return ((root, query, builder) -> {
           sortByFilter(root, query, builder, filter);
           return builder.conjunction();
        });
    }

    private static void sortByFilter(
            Root<StudentEntity> root,
            CriteriaQuery<?> query,
            CriteriaBuilder builder,
            PaginatedStudentSearchParam filter) {

        var sortBy = filter.getSortBy();
        if (StringUtils.isBlank(sortBy)) {
            createSortingById(query, builder, root);
        }
    }

    private static void createSortingById(
            CriteriaQuery<?> query,
            CriteriaBuilder builder,
            Root<StudentEntity> root) {

        var idPath = root.get(StudentEntity_.ID);
        query.orderBy(builder.asc(idPath));
    }

}
