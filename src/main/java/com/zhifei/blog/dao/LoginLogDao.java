package com.zhifei.blog.dao;


import com.zhifei.blog.entity.LoginLog;
import org.apache.ibatis.annotations.Param;

public interface LoginLogDao {
     void setLoginLog(@Param("loginLog") LoginLog setLoginLog);
}
