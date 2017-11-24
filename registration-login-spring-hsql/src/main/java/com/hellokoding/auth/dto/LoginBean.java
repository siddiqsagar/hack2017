package com.hellokoding.auth.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by siddiq on 24/11/17.
 */
public class LoginBean {

    private String username;
    private String password;

    /*@JsonIgnore
    private String type;*/

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   /* public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }*/
}
