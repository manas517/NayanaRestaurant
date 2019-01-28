
package com.nayanatech.nayanarestaurant.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StPrice {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("price_item")
    @Expose
    private String priceItem;
    @SerializedName("menu_price")
    @Expose
    private String menuPrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPriceItem() {
        return priceItem;
    }

    public void setPriceItem(String priceItem) {
        this.priceItem = priceItem;
    }

    public String getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(String menuPrice) {
        this.menuPrice = menuPrice;
    }

}
