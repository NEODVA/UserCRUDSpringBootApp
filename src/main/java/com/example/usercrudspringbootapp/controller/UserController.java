package com.example.usercrudspringbootapp.controller;

import javax.validation.Valid;

import com.example.usercrudspringbootapp.entity.User;
import com.example.usercrudspringbootapp.request.UserRequest;
import com.example.usercrudspringbootapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> list = userService.getAllUser();
        return new ResponseEntity<List<User>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer userId) {
        User user = userService.getUserById(userId);
        return new ResponseEntity<User>(user, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody UserRequest userRequest) {
        User user = userService.createUser(userRequest);
        return new ResponseEntity<User>(user, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@RequestBody UserRequest userRequest, @PathVariable("id") Integer userId) {
        User user = userService.updateUser(userRequest, userId);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> userDelete(@PathVariable("id") Integer userId) {

        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
