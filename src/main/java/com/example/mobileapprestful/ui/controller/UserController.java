package com.example.mobileapprestful.ui.controller;

import com.example.mobileapprestful.ui.model.request.UserDetailsRequestModel;
import com.example.mobileapprestful.ui.model.response.UserRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @GetMapping(path = "/{userId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
        UserRest returnValue = new UserRest();
        returnValue.setEmail("test@test.com");
        returnValue.setFirstName("Jevin");
        returnValue.setLastName("Kames");
        return new ResponseEntity<>(returnValue, HttpStatus.OK);
    }

    //    To implement native POST validation, model must be annotated with @Valid.
//    Inside the model is where those validations are implemented.
    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
        UserRest returnValue = new UserRest();
        returnValue.setEmail(userDetails.getEmail());
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());
        returnValue.setEmail(userDetails.getEmail());
        return new ResponseEntity<>(returnValue, HttpStatus.OK);
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
