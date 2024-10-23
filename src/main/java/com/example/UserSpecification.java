package com.example;

import javax.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;


@RequiredArgsConstructor
public class UserSpecification {

    // Specification to filter by firstName
    public static Specification<Users> hasFirstName(String firstName) {
        return (Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            if (firstName == null || firstName.isEmpty()) {
                // No filtering if firstName is null or empty
                return criteriaBuilder.conjunction();
            }
            // Using LIKE query for pattern matching
            return criteriaBuilder.like(root.get("firstName"), "%" + firstName + "%");
        };
    }

    // Specification to filter by lastName
    public static Specification<Users> hasLastName(String lastName) {
        return (Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            if (lastName == null || lastName.isEmpty()) {
                return criteriaBuilder.conjunction();  // No filtering if lastName is null or empty
            }
            // Using LIKE query for pattern matching
            return criteriaBuilder.like(root.get("lastName"), "%" + lastName + "%");
        };
    }

    // Specification to filter by age greater than a given value
    public static Specification<Users> hasAgeGreaterThan(double age) {
        return (Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("age"), age);
    }
}