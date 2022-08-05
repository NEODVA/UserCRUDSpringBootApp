package com.example.usercrudspringbootapp.service;

import com.example.usercrudspringbootapp.entity.UserPreferences;
import com.example.usercrudspringbootapp.repository.UserPreferencesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPreferencesService {

    private final UserPreferencesRepository userPreferencesRepository;

    @Autowired
    public UserPreferencesService(UserPreferencesRepository userPreferencesRepository) {
        this.userPreferencesRepository = userPreferencesRepository;
    }

    public UserPreferences saveUserPreferences(UserPreferences userPreferences){
        return userPreferencesRepository.saveAndFlush(userPreferences);
    }
    public  UserPreferences getUserPreferencesById(Integer userPreferencesId){
        return userPreferencesRepository.findById(userPreferencesId).get();
    }
    public UserPreferences updateUserPreferences(UserPreferences userPreferences, Integer userPreferencesId){
        UserPreferences newUserPreferences = getUserPreferencesById(userPreferencesId);
        newUserPreferences.setReceiveEmail(userPreferences.getReceiveEmail());
        newUserPreferences.setReceiveSms(!userPreferences.getReceiveEmail());
        return  userPreferencesRepository.save(newUserPreferences);
    }
    public void deleteUserPreferences(Integer userPreferencesId){
        userPreferencesRepository.deleteById(userPreferencesId);
    }
}
