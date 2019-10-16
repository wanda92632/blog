package com.zhifei.blog.shiro;

import com.zhifei.blog.service.PermissionService;
import com.zhifei.blog.service.RoleService;
import com.zhifei.blog.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import com.zhifei.blog.entity.Role;
import com.zhifei.blog.entity.User;
import com.zhifei.blog.service.impl.PermissionServiceImpl;
import com.zhifei.blog.service.impl.RoleServiceImpl;
import com.zhifei.blog.service.impl.UserServiceImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    PermissionService permissionService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取当前登录用户名
        String userName = principalCollection.getPrimaryPrincipal().toString();
        // 从数据库或者缓存中获取角色数据
        List<Role> roleList = roleService.getRolesByUserName(userName);
        Set<String> roles = new HashSet<>();
        if(roleList.size()>0){
            for(Role role :roleList){
                roles.add(role.getRoleName());
            }
        }else {
            return null;
        }
        // 从数据库或者缓存中获取权限数据
        Set<String> permissions = permissionService.getPermissionsByUserName(userName);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(roles);
        authorizationInfo.setStringPermissions(permissions);
        return authorizationInfo;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = (String) authenticationToken.getPrincipal();
        User user = userService.findUserByUserName(userName);
        if (user == null) {
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUserName(), user.getPassword(),
                ByteSource.Util.bytes(user.getCredentialsSalt()), getName());
        return authenticationInfo;
    }
}
