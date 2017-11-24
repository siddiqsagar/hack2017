package com.rise.mongotest.menu;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MenuRepository extends MongoRepository<MenuItems, String> {

    MenuItems save(MenuItems menuItems);

    MenuItems findByUserId(String userId);
}
