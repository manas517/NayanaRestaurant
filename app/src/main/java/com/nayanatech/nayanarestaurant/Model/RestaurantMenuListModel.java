package com.nayanatech.nayanarestaurant.Model;

public class RestaurantMenuListModel {
    private String MenuItem;
    private String subItem;
    private String itemPrice;


    public String getMenuItem() {
        return MenuItem;
    }

    public void setMenuItem(String menuItem) {
        MenuItem = menuItem;
    }

    public String getSubItem() {
        return subItem;
    }

    public void setSubItem(String subItem) {
        this.subItem = subItem;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public RestaurantMenuListModel(String menuItem, String subItem, String itemPrice) {
        MenuItem = menuItem;
        this.subItem = subItem;
        this.itemPrice = itemPrice;
    }
}
