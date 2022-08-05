package com.example.usercrudspringbootapp.controller;

import javax.validation.Valid;
import com.example.usercrudspringbootapp.entity.User;
import com.example.usercrudspringbootapp.entity.UserIdRoleId;
import com.example.usercrudspringbootapp.entity.UserPreferences;
import com.example.usercrudspringbootapp.request.UserRequest;
import com.example.usercrudspringbootapp.service.UserIdRoleIdService;
import com.example.usercrudspringbootapp.service.UserPreferencesService;
import com.example.usercrudspringbootapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserPreferencesService userPreferencesService;
    private final UserIdRoleIdService userIdRoleIdService;

    @Autowired
    public UserController(UserService userService, UserPreferencesService userPreferencesService, UserIdRoleIdService userIdRoleIdService) {
        this.userService = userService;
        this.userPreferencesService = userPreferencesService;

        this.userIdRoleIdService = userIdRoleIdService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        List<User> list = userService.readUser();
        return new ResponseEntity<List<User>>(list, new HttpHeaders(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUsersById(@PathVariable("id") Integer userId) {
        User user = userService.getUserById(userId);
        return  new ResponseEntity<User>(user, new HttpHeaders(),HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@Valid @RequestBody UserRequest userRequest) {
        User user = userService.saveUser(userRequest);
        return new ResponseEntity<User>(user, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<User> updateUser(@RequestBody UserRequest userRequest,@PathVariable("id") Integer userId){
        User user = userService.updateUser(userRequest,userId);
        return new ResponseEntity<User>(user, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus userDelete(@PathVariable("id") Integer userId){

        userService.deleteUser(userId);
        return HttpStatus.FORBIDDEN;
    }

}
