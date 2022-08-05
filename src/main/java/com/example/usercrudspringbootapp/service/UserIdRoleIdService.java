package com.example.usercrudspringbootapp.service;

import com.example.usercrudspringbootapp.entity.UserIdRoleId;
import com.example.usercrudspringbootapp.repository.UserIdRoleIdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserIdRoleIdService {

    private final UserIdRoleIdRepository userIdPrefIdRepository;

    @Autowired
    public UserIdRoleIdService(UserIdRoleIdRepository userIdPrefIdRepository) {
        this.userIdPrefIdRepository = userIdPrefIdRepository;
    }


    public UserIdRoleId saveUserIdRoleId(UserIdRoleId userIdPrefId){
        return userIdPrefIdRepository.saveAndFlush(userIdPrefId);
    }
    public List readUserIdRoleId(){
        return (List<UserIdRoleId>) userIdPrefIdRepository.findAll();
    }

    public void deleteUserIdRoleId(Integer userPrefId){
        userIdPrefIdRepository.deleteById(userPrefId);
    }
    public UserIdRoleId findByUserRolId(Integer userId, Integer roleId){
        return userIdPrefIdRepository.findUserIdRoleIdBy(userId,roleId);
    }
    public void deleteByUserId(Integer userId){
        userIdPrefIdRepository.deleteByUserId(userId);
    }
}
