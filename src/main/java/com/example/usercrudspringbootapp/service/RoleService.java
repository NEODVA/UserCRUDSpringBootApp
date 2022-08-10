package com.example.usercrudspringbootapp.service;

import com.example.usercrudspringbootapp.entity.Role;
import com.example.usercrudspringbootapp.entity.User;
import com.example.usercrudspringbootapp.repository.RoleRepository;
import com.example.usercrudspringbootapp.repository.UserRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    public Role createRole(Role role) {
        return roleRepository.saveAndFlush(role);
    }

    public List<Role> getAllRole() {
        return (List<Role>) roleRepository.findAll();
    }

    public void deleteRole(Integer roleId) {
        Role role = roleRepository.findById(roleId).orElse(null);
        if (role != null) {
            for (User d : role.getUsers())
                d.getRole().remove(role);

            roleRepository.deleteById(roleId);

        } else {
            new ResourceNotFoundException("Not found Role  ");
        }

    }

    public void deleteRoleFromUser(Integer userId, Integer roleId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Not found User with id = " + userId));

        user.removeRole(roleId);
        userRepository.save(user);
    }

    public List<User> getAllUsersByRoleId(Integer roleId) {
        if (!roleRepository.existsById(roleId)) {
            new ResourceNotFoundException("Not found Role with id = " + roleId);
        }
        List<User> users = userRepository.findUsersByRolesId(roleId);
        return users;
    }
}
