package com.example.mobileapprestful.ui.controller;

import com.example.mobileapprestful.ui.exceptions.UserServiceException;
import com.example.mobileapprestful.ui.model.request.UpdateUserDetailsRequestModel;
import com.example.mobileapprestful.ui.model.request.UserDetailsRequestModel;
import com.example.mobileapprestful.ui.model.response.UserRest;
import com.example.mobileapprestful.ui.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("users") //http:localhost:8080/users
public class UserController {
    //  Temporary user data storage here
    Map<String, UserRest> users;

    //  @Autowired injects UserService when UserController is created
    @Autowired
    UserService userService;

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
        if (true) throw new UserServiceException("User service exception thrown.");
        if (users.containsKey(userId))
            return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //    To implement native POST validation, model must be annotated with @Valid.
//    Inside the model is where those validations are implemented.
    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
        UserRest returnValue = userService.createUser(userDetails);
        return new ResponseEntity<>(returnValue, HttpStatus.OK);
    }

    @PutMapping(path = "/{userId}",
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public UserRest updateUser(@PathVariable String userId, @RequestBody UpdateUserDetailsRequestModel userDetails) {
        UserRest storedUserDetails = users.get(userId);
        storedUserDetails.setFirstName(userDetails.getFirstName());
        storedUserDetails.setLastName(userDetails.getLastName());
        users.put(userId, storedUserDetails);
        return storedUserDetails;
    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        users.remove(userId);
        return ResponseEntity.noContent().build();
    }
}
