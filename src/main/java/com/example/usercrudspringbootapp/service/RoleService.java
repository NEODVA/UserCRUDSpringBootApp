package com.example.usercrudspringbootapp.service;

import com.example.usercrudspringbootapp.entity.Role;
import com.example.usercrudspringbootapp.entity.UserIdRoleId;
import com.example.usercrudspringbootapp.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleService {
    private final RoleRepository roleRepository;
    private final UserIdRoleIdService userIdRoleIdService;
    @Autowired
    public RoleService(RoleRepository roleRepository, UserIdRoleIdService userIdRoleIdService) {
        this.roleRepository = roleRepository;
        this.userIdRoleIdService = userIdRoleIdService;
    }

    public Role saveRole(Role role){
        return roleRepository.saveAndFlush(role);
    }
    public List readRole(){
        return (List<Role>) roleRepository.findAll();
    }

    public void deleteRole(Integer roleId){
        List<UserIdRoleId> list = userIdRoleIdService.readUserIdRoleId();
        for (int i = 0;i<list.size(); i++){
            if (roleId == list.get(i).getRoleId()){
                userIdRoleIdService.deleteUserIdRoleId(list.get(i).getId());
            }

        }
        roleRepository.deleteById(roleId);
    }
}
