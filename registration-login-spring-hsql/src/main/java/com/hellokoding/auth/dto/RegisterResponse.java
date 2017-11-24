package com.hellokoding.auth.dto;

/**
 * Created by siddiq on 24/11/17.
 */
public class RegisterResponse {

    private String status;
    private String mesage;
    private String userId;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMesage() {
        return mesage;
    }

    public void setMesage(String mesage) {
        this.mesage = mesage;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
