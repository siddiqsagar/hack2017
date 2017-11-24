package com.rise.menu.service;

import com.rise.menu.dto.Menu;
import com.rise.menu.dto.MenuRequest;
import com.rise.menu.dto.MenuResponse;

import java.util.List;

public interface MenuService {

    MenuResponse addMenus(MenuRequest menuRequest);

    List<Menu> getMenus(String userId);
}
