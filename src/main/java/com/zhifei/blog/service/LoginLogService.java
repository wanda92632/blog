package com.zhifei.blog.service;

import com.zhifei.blog.entity.LoginLog;

public interface LoginLogService {

    /*
     * 写入登录日志
     * */
    void setLoginLog(LoginLog loginLog);
}
