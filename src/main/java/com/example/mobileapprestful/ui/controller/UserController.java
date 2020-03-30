package com.example.mobileapprestful.ui.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users") //http:localhost:8080/users
public class UserController {
    @GetMapping
    public String getUser() {
        return "user is called";
    }

    @PostMapping
    public String createUser() {
        return "user is created";
    }

    @PutMapping
    public String updateUser() {
        return "user is updated";
    }

    @DeleteMapping
    public String deleteUser() {
        return "user is deleted";
    }
}
