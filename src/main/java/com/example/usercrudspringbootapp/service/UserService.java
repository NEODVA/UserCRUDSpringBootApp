package com.example.usercrudspringbootapp.service;

import com.example.usercrudspringbootapp.entity.Role;
import com.example.usercrudspringbootapp.entity.User;
import com.example.usercrudspringbootapp.entity.UserPreferences;
import com.example.usercrudspringbootapp.repository.RoleRepository;
import com.example.usercrudspringbootapp.repository.UserPreferencesRepository;
import com.example.usercrudspringbootapp.repository.UserRepository;
import com.example.usercrudspringbootapp.request.UserRequest;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserPreferencesRepository userPreferencesRepository;


    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, UserPreferencesRepository userPreferencesRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userPreferencesRepository = userPreferencesRepository;
    }

    public User createUser(UserRequest userRequest) {

        User user1 = roleRepository.findById(userRequest.getRoleId()).map(role -> {
            User user = new User();
            user.setLastName(userRequest.getLastName());
            user.setFirstName(userRequest.getFirstName());
            user.setUserName(userRequest.getUserName());
            user.setPassword(userRequest.getPassword());
            user.setPhoneNumber(userRequest.getPhoneNumber());
            user.setEmail(userRequest.getEmail());
            user.setDateOfBrith(userRequest.getDateOfBrith());
            user.setHeight(userRequest.getHeight());
            user.setWeight(userRequest.getWeight());
            user.addRole(role);
            UserPreferences preferences = new UserPreferences(userRequest.getPeferencesInfoEmail(), userRequest.getPreferencesInfoSms());
            //userPreferencesRepository.save(preferences);
            user.setUserPreferences(preferences);
            //preferences.setUser(user);

            return userRepository.save(user);

        }).orElseThrow(() ->
                new ResourceNotFoundException("Not found Role with id = " + userRequest.getRoleId()));
        return user1;
    }

    public List<User> getAllUser() {
        return (List<User>) userRepository.findAll();
    }

    public User getUserById(Integer userId) {
        return userRepository.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException("Not found User with id = " + userId));
    }

    public User updateUser(UserRequest userRequest, Integer userId) {
        User user = getUserById(userId);

        if (userRequest.getFirstName() != null) {
            user.setFirstName(userRequest.getFirstName());
        }
        if (userRequest.getLastName() != null) {
            user.setLastName(userRequest.getLastName());
        }
        if (userRequest.getUserName() != null) {
            user.setUserName(userRequest.getUserName());
        }
        if (userRequest.getPassword() != null) {
            user.setPassword(userRequest.getPassword());
        }
        if (userRequest.getPhoneNumber() != null) {
            user.setPhoneNumber(userRequest.getPhoneNumber());
        }
        if (userRequest.getEmail() != null) {
            user.setEmail(userRequest.getEmail());
        }
        if (userRequest.getDateOfBrith() != null) {
            user.setDateOfBrith(userRequest.getDateOfBrith());
        }
        if (userRequest.getHeight() != null) {
            user.setHeight(userRequest.getHeight());
        }
        if (userRequest.getWeight() != null) {
            user.setWeight(userRequest.getWeight());
        }

        if (userRequest.getRoleId() != null) {
            Role role = roleRepository.findById(userRequest.getRoleId()).orElseThrow(() ->
                    new ResourceNotFoundException("Not found Role with id = " + userRequest.getRoleId()));
            user.addRole(role);
        }
        return userRepository.save(user);
    }

    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);

    }
}
