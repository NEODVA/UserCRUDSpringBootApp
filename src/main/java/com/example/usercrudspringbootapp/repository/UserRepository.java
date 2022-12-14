package com.example.usercrudspringbootapp.repository;

import com.example.usercrudspringbootapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findUsersByRolesId(Integer roleId);
}
