package com.zhifei.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhifei.blog.dao.PermissionDao;
import com.zhifei.blog.service.PermissionService;

import java.util.Set;

/**
 * @author ZhiFei
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    /**
     * 获取权限数据
     * @param permissionId
     * @return
     */
    @Override
    public Set<String> getPermissionsByUserName(String permissionId){
        Set<String> permissionSet = permissionDao.getPermissionsByUserName(permissionId);
        return permissionSet;
    }
}
