package com.zhifei.blog.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author ZhiFei
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User{
    private Integer userId;
    private String userName;
    private String password;
    private String salt;
    private String userNickname;
    private String userEmail;
    private String userLink;
    private String userIcon;
    private String userRegistrationTime;
    private String lastVisit;
    private String lastIP;
    private int userState;

    public String getCredentialsSalt() {
        return userName + salt + salt;
    }
}
