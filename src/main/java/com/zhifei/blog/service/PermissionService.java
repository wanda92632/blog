package com.zhifei.blog.service;

import java.util.Set;

public interface PermissionService {

    /**
     * 获取权限数据
     *
     * @param permissionId
     * @return
     */
    Set<String> getPermissionsByUserName(String permissionId);
}
