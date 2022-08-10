package com.example.usercrudspringbootapp.repository;

import com.example.usercrudspringbootapp.entity.UserPreferences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserPreferencesRepository extends JpaRepository<UserPreferences,Integer> {

}
