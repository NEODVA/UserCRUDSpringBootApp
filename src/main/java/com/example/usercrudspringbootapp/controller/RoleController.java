package com.example.usercrudspringbootapp.controller;

import com.example.usercrudspringbootapp.entity.Role;
import com.example.usercrudspringbootapp.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    private final RoleService roleService;
    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }
    @PostMapping("/create")
    public Role saveRole(@Valid @RequestBody Role role){
        return  roleService.saveRole(role);
    }
    @GetMapping
    public List<Role> getRole(){
        return roleService.readRole();
    }

    @DeleteMapping("/{id}")
    public String roleDelete(@PathVariable("id") Integer roleId){
        roleService.deleteRole(roleId);
        return "Deleted Successfully";
    }
}
