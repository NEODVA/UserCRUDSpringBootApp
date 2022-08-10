package com.example.usercrudspringbootapp.controller;

import com.example.usercrudspringbootapp.entity.Role;
import com.example.usercrudspringbootapp.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RoleController {
    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;

    }

    @PostMapping("/roles")
    public ResponseEntity<Role> createRole(@Valid @RequestBody Role role) {
        return new ResponseEntity<>(roleService.createRole(role), HttpStatus.OK);
    }

    @GetMapping("/roles")
    public ResponseEntity<List<Role>> getAllRole() {
        return new ResponseEntity<>(roleService.getAllRole(), HttpStatus.OK);
    }

    @DeleteMapping("/roles/{id}")
    public ResponseEntity<HttpStatus> deleteRole(@PathVariable("id") Integer roleId) {
        roleService.deleteRole(roleId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/users/{userId}/roles/{roleId}")
    public ResponseEntity<HttpStatus> deleteRoleFromUser(@PathVariable("userId") Integer userId, @PathVariable("roleId") Integer roleId) {
        roleService.deleteRoleFromUser(userId, roleId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
