package com.zhifei.blog.service.impl;

import com.zhifei.blog.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhifei.blog.dao.UserDao;
import com.zhifei.blog.entity.User;
import com.zhifei.blog.entity.UserRole;
import com.zhifei.blog.service.RoleService;
import com.zhifei.blog.service.UserService;
import com.zhifei.blog.util.ImageUtil;
import com.zhifei.blog.util.PathUtil;

import java.io.InputStream;

/**
 * @author ZhiFei
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleService roleService;

    /**
     * 查询匹配用户数
     *
     * @param userName
     * @param password
     * @return
     */
    @Override
    public boolean hasMatchUser(String userName, String password) {
        int matchCount = userDao.matchUserNumber(userName, password);
        return matchCount > 0;
    }

    /**
     * 查找用户信息根据用户名
     *
     * @param userName
     * @return
     */
    @Override
    public User findUserByUserName(String userName) {
        User user = userDao.findUserByUserName(userName);
        return user;
    }

    /**
     * 用户注册
     *
     * @param user
     */
    @Override
    public void userRegistered(User user) {
        int effectedNum = userDao.userRegistered(user);
        if(effectedNum>0){
            UserRole userRole = new UserRole();
            userRole.setUserId(user.getUserId());
            userRole.setRoleId(2);
         roleService.setRolesByUserId(userRole);
        }
    }


    /**
     * 更新用户数据
     *
     * @param user
     */
    @Override
    public void upUserData(User user) {
        userDao.upUserData(user);
    }

    /**
     * 查询用户信息
     *
     * @param userId
     * @return
     */
    @Override
    public User getUserData(int userId) {
        return userDao.getUserData(userId);
    }

    /**
     * 查询用户数
     *
     * @return
     */
    @Override
    public int queryUserSum() {
        return userDao.queryUserSum();
    }

    /**
     * 更新用户头像
     *
     * @param userId
     * @param inputStream
     */
    @Override
    public void upUserIcon(String userId, InputStream inputStream){
        //获取shop图片目录的相对值路径
        //String dest = PathUtil.getShopImagePath(userId);
        //String shopImgAddr = ImageUtil.generateThumbnail(inputStream, fileName, dest);
        String path= UploadUtil.prefix+UploadUtil.uploadFile(inputStream);
        userDao.upUserIcon(userId, path);
    }
}
