package com.example.usercrudspringbootapp.repository;

import com.example.usercrudspringbootapp.entity.UserIdRoleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserIdRoleIdRepository extends JpaRepository<UserIdRoleId,Integer> {
    @Query("SELECT t FROM UserIdRoleId t where t.userId = :userId AND t.roleId = :roleId ")
    UserIdRoleId findUserIdRoleIdBy(@Param("userId")Integer userId,@Param("roleId") Integer roleId);

    @Query("DELETE FROM UserIdRoleId c WHERE c.userId = :userId")
    void deleteByUserId(@Param("userId") Integer userId);
}

