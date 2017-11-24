package com.rise.menu.service;

import com.rise.constant.Constant;
import com.rise.menu.dto.Menu;
import com.rise.menu.dto.MenuRequest;
import com.rise.menu.dto.MenuResponse;
import com.rise.mongotest.menu.MenuDao;
import com.rise.mongotest.menu.MenuItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    public MenuResponse addMenus(MenuRequest menuRequest) {
        MenuResponse menuResponse = new MenuResponse();
        String id = menuDao.addMenus(menuRequest);
        if(null != id && !"".equals(id)) {
            menuResponse.setStatus(Constant.SUCCESS);
            menuResponse.setMessage("Menu added successfully");
        } else {
            menuResponse.setStatus(Constant.FAILURE);
            menuResponse.setMessage("Some Error occurred while adding menu. Please try again later");
        }
        return menuResponse;
    }

    @Override
    public List<Menu> getMenus(String userId) {
        List<Menu> menuList = new ArrayList<>();
        MenuItems menuItems = menuDao.getMenus(userId);
        if(null != menuItems) {
            menuList = menuItems.getMenuList();
        } else {
            menuList = null;
        }

        return menuList;
    }
}
