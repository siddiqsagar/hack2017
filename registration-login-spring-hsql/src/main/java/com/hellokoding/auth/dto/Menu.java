package com.hellokoding.auth.dto;

public class Menu {

    private String itemName;
    private String price;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "MenuItems{" +
                "itemName='" + itemName + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
