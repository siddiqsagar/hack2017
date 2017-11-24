package com.hellokoding.auth.dto;

/**
 * Created by siddiq on 24/11/17.
 */
public class LoginBean {

    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
