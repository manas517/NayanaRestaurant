package com.nayanatech.nayanarestaurant.Model;

public class RestaurantModelDemo {
    private String restaurant_name;
    private int restaurant_image;


    public String getRestaurant_name() {
        return restaurant_name;
    }

    public void setRestaurant_name(String restaurant_name) {
        this.restaurant_name = restaurant_name;
    }

    public int getRestaurant_image() {
        return restaurant_image;
    }

    public void setRestaurant_image(int restaurant_image) {
        this.restaurant_image = restaurant_image;
    }

    public RestaurantModelDemo(String restaurant_name, int restaurant_image) {
        this.restaurant_name = restaurant_name;
        this.restaurant_image = restaurant_image;
    }
}
