package com.example.mobileapprestful.ui.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users") //http:localhost:8080/users
public class UserController {
    @GetMapping
    //default value will make page parameter optional because a value will be assigned if there is none
    //a default value must be set due to page and limit declared as a primitive type
    public String getUsers(@RequestParam(value = "page", defaultValue = "111", required = false) int page,
                           @RequestParam(value = "limit", defaultValue = "10") int limit,
                           @RequestParam(value = "sortBy", defaultValue = "default", required = false) String sortBy) {
        return "Users are called from page " + page + " with limit " + limit + " and sort by " + sortBy;
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
