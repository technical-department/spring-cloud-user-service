package com.cloud.oauth.util;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;


public class UserJwt extends User {
    private String id;    //用户ID
    private String name;  //用户名字

//    /**
//     * 用户名;
//     */
//    private String userName;

    /**
     * 用户性别; 1-男，0-女
     */
    private String userSex;

    /**
     * 手机号码;
     */
    private String userMobile;

    private String comny;//设置公司

    public UserJwt(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getComny() {
        return comny;
    }

    public void setComny(String comny) {
        this.comny = comny;
    }

}
