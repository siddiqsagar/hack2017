package com.rise.menu.controller;

import com.rise.menu.dto.Menu;
import com.rise.menu.dto.MenuRequest;
import com.rise.menu.dto.MenuResponse;
import com.rise.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping(method = RequestMethod.POST, value = "/addMenus", produces = MediaType.APPLICATION_JSON_VALUE)
    public MenuResponse addMenus(HttpServletRequest httpServletRequest, @RequestBody MenuRequest menuRequest) {
        MenuResponse menuResponse = menuService.addMenus(menuRequest);
        return menuResponse;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/menus", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Menu> menus(HttpServletRequest httpServletRequest, @RequestParam("id") String id) {
        List<Menu> menuList = menuService.getMenus(id);
        return menuList;
    }

}
