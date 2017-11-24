package com.rise.menu.dto;

import java.util.List;

public class MenuRequest {

    private String userId;

    private List<Menu> menuList;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    @Override
    public String toString() {
        return "MenuRequest{" +
                "userId='" + userId + '\'' +
                ", menuList=" + menuList +
                '}';
    }
}
