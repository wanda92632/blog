package com.zhifei.blog.service.impl;


import com.zhifei.blog.dao.LoginLogDao;
import com.zhifei.blog.entity.LoginLog;
import com.zhifei.blog.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ZhiFei
 */
@Service
public class LoginLogServiceImpl implements LoginLogService {
    @Autowired
    LoginLogDao loginLogDao;

    /**
     * 写入登录日志
     * @param loginLog
     */
    @Override
    public void setLoginLog(LoginLog loginLog)
    {
        loginLogDao.setLoginLog(loginLog);
        return;
    }
}
