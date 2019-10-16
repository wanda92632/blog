package com.zhifei.blog.dao;

import org.apache.ibatis.annotations.Param;
import com.zhifei.blog.entity.User;

/**
 * @author ZhiFei
 */
public interface UserDao {
    /**
     * 用户匹配数
     * @param userName
     * @param password
     * @return
     */
    int matchUserNumber(@Param("userName") String userName, @Param("password") String password);

    /**
     * 查询用户信息-用户名
     * @param userName
     * @return
     */
    User findUserByUserName(@Param("userName") String userName);

    /**
     * 更新用户数据
     * @param user
     * @return
     */
    int upUserData(User user);

    /**
     * 获取用户数据-用户ID
     * @param userId
     * @return
     */
    User getUserData(@Param("userId") int userId);

    /**
     * 用户注册
     * @param user
     * @return
     */
    int userRegistered(@Param("user") User user);

    /**
     * 查询用户数
     * @return
     */
    int queryUserSum();

    /**
     * 更新用户头像
     * @param userId
     * @param userIcon
     */
    void upUserIcon(@Param("userId") String userId, @Param("userIcon") String userIcon);
}
