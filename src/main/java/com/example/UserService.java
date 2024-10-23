package com.example;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> searchUser(String firstName, String lastName, Double age) {
        // Combine specifications using `and()`
        Specification<Users> specification = Specification
                .where(UserSpecification.hasFirstName(firstName))
                .and(UserSpecification.hasLastName(lastName))
                .and(age != null ? UserSpecification.hasAgeGreaterThan(age) : null);

        // Fetch products based on the combined specification
        return userRepository.findAll(specification);
    }
}
