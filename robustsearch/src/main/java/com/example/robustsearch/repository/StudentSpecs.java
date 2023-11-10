package com.example.robustsearch.repository;

import com.example.robustsearch.entity.Student;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class StudentSpecs {
    public static Specification<Student> dynamicQuery(
            String name, String department, String address) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (name != null && !name.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("department"), name));
            }
            if (department != null && !department.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("department"), department));
            }
            if (address != null && !address.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("address"), address));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
