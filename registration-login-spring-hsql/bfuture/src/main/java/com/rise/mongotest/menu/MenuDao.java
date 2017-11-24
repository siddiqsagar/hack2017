package com.rise.mongotest.menu;

import com.rise.menu.dto.MenuRequest;

public interface MenuDao {

    String addMenus(MenuRequest menuRequest);

    MenuItems getMenus(String userId);
}
