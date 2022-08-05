package com.example.usercrudspringbootapp.service;
import com.example.usercrudspringbootapp.entity.User;
import com.example.usercrudspringbootapp.entity.UserIdRoleId;
import com.example.usercrudspringbootapp.entity.UserPreferences;
import com.example.usercrudspringbootapp.repository.UserRepository;
import com.example.usercrudspringbootapp.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserIdRoleIdService userIdRoleIdService;
    private final UserPreferencesService userPreferencesService;



    @Autowired
    public UserService(UserRepository userRepository, UserIdRoleIdService userIdRoleIdService, UserPreferencesService userPreferencesService) {
        this.userRepository = userRepository;
        this.userIdRoleIdService = userIdRoleIdService;
        this.userPreferencesService = userPreferencesService;

    }
    public User saveUser(UserRequest userRequest){
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

        UserPreferences userPreferences = new UserPreferences();
        userPreferences.setReceiveSms(userRequest.getPreferencesInfoSms());
        userPreferences.setReceiveEmail(!userRequest.getPreferencesInfoSms());
        userPreferences = userPreferencesService.saveUserPreferences(userPreferences);

        user.setPreferencesId(userPreferences.getId());
        user = userRepository.saveAndFlush(user);

        UserIdRoleId userIdRoleId = userIdRoleIdService.findByUserRolId(user.getId(),userRequest.getRoleId());

        if (userRequest.getRoleId() != null && userIdRoleId == null ){

            userIdRoleId = new UserIdRoleId();
            userIdRoleId.setUserId(user.getId());
            userIdRoleId.setRoleId(userRequest.getRoleId());

            userIdRoleIdService.saveUserIdRoleId(userIdRoleId);
        }

        userRepository.saveAndFlush(user);
        return user;
    }
    public List readUser(){
        return (List<User>) userRepository.findAll();
    }
    public User getUserById(Integer userId){
        return userRepository.findById(userId).get();
    }
    public User updateUser(UserRequest userRequest, Integer userId){
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
        if (userRequest.getPreferencesId() != null){
            UserPreferences userPreferences =  userPreferencesService.getUserPreferencesById(userRequest.getPreferencesId());
            if (userRequest.getPreferencesInfoSms() != userPreferences.getReceiveSms()){
                userPreferences.setReceiveSms(userRequest.getPreferencesInfoSms());
                userPreferences.setReceiveEmail(!userRequest.getPreferencesInfoSms());
                userPreferencesService.updateUserPreferences(userPreferences,userRequest.getPreferencesId());
            }
        }


        if (userRequest.getRoleId() != null){
            UserIdRoleId userIdRoleId = userIdRoleIdService.findByUserRolId(user.getId(),userRequest.getRoleId());

            if (userRequest.getRoleId() != null && userIdRoleId == null ){

                userIdRoleId = new UserIdRoleId();
                userIdRoleId.setUserId(user.getId());
                userIdRoleId.setRoleId(userRequest.getRoleId());

                userIdRoleIdService.saveUserIdRoleId(userIdRoleId);
            }


        }

        return  userRepository.saveAndFlush(user);
    }
    public void deleteUser(Integer userId){
        User user = userRepository.findById(userId).orElse(null);
        if (user != null){
            userPreferencesService.deleteUserPreferences(user.getPreferencesId());
            userRepository.deleteById(userId);
            userIdRoleIdService.deleteByUserId(userId);
        }
    }
}
