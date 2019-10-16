package com.zhifei.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhifei.blog.dao.RoleDao;
import com.zhifei.blog.entity.Role;
import com.zhifei.blog.entity.UserRole;
import com.zhifei.blog.service.RoleService;

import java.util.List;

/**
 * @author ZhiFei
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    /**
     * 获取角色数据
     * @param userName
     * @return
     */
    @Override
    public List<Role> getRolesByUserName(String userName){
        List<Role> roleList = roleDao.getRolesByUserName(userName);
        return roleList;
    }

    /**
     * 添加用户角色
     *
     * @param userRole
     * @return
     */
    @Override
    public int setRolesByUserId(UserRole userRole) {
        return roleDao.setRolesByUserId(userRole);
    }
}
