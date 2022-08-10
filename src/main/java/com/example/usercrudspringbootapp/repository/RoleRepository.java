package com.example.usercrudspringbootapp.repository;

import com.example.usercrudspringbootapp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    List<Role> findRolesByUsersId(Integer userId);
}
