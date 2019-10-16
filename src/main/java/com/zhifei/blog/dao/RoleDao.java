package com.zhifei.blog.dao;

import org.apache.ibatis.annotations.Param;
import com.zhifei.blog.entity.Role;
import com.zhifei.blog.entity.UserRole;

import java.util.List;

public interface RoleDao {
    List<Role> getRolesByUserName(@Param("userName") String userName);

    int setRolesByUserId(@Param("userRole") UserRole userRole);
}