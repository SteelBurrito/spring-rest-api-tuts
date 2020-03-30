package com.example.mobileapprestful.ui.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users") //http:localhost:8080/users
public class UserController {
    @GetMapping
    public String getUsers(@RequestParam(value = "page") int page, @RequestParam(value = "limit") int limit) {
        return "Users are called from page " + page + " with limit " + limit;
    }

    @GetMapping(path = "/{userId}")
    public String getUser(@PathVariable String userId) {
        return "User " + userId + " is called";
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
