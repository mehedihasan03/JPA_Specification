package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private final UserService userService;

    public ProductController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<Users> searchProducts(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) Double age) {
        System.out.println("firstName = " + firstName);
        System.out.println("result = " + userService.searchUser(firstName, lastName, age));
        return userService.searchUser(firstName, lastName, age);
    }
}
