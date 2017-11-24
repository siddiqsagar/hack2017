package com.rise.mongotest.menu;

import com.rise.menu.dto.Menu;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "menuitems")
public class MenuItems {

    @Id
    private String id;

    private String userId;

    List<Menu> menuList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
        return "MenuItems{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", menuList=" + menuList +
                '}';
    }
}
