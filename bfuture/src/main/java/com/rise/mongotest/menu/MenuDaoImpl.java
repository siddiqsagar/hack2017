package com.rise.mongotest.menu;

import com.rise.menu.dto.MenuRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("menuDao")
public class MenuDaoImpl implements MenuDao {

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public String addMenus(MenuRequest menuRequest) {
        MenuItems menuItems = new MenuItems();
        menuItems.setUserId(menuRequest.getUserId());
        menuItems.setMenuList(menuRequest.getMenuList());

        MenuItems menuItems1 = menuRepository.save(menuItems);

        return menuItems1.getId();
    }

    @Override
    public MenuItems getMenus(String userId) {
        MenuItems menuItems = menuRepository.findByUserId(userId);
        return menuItems;
    }
}
