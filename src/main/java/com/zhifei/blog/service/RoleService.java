package com.zhifei.blog.service;

import com.zhifei.blog.entity.Role;
import com.zhifei.blog.entity.UserRole;

import java.util.List;

/**
 * @author ZhiFei
 */
public interface RoleService {

    /**
     * 获取角色数据
     * @param userName
     * @return
     */
    List<Role> getRolesByUserName(String userName);

    /**
     * 添加用户角色
     * @param userRole
     * @return
     */
    int setRolesByUserId(UserRole userRole);
}
