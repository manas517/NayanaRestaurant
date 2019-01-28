
package com.nayanatech.nayanarestaurant.Model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item implements Serializable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;

    @SerializedName("rest_id")
    @Expose
    private String restId;

    @SerializedName("nav_type")
    @Expose
    private String navType;

    @SerializedName("menu_ID")
    @Expose
    private String menuID;

    @SerializedName("imagename")
    @Expose
    private String imagename;

    @SerializedName("imageURL")
    @Expose
    private String imageURL;

    @SerializedName("live_status")
    @Expose
    private String liveStatus;
    @SerializedName("live_message")
    @Expose
    private String liveMessage;
    @SerializedName("combo_id")
    @Expose
    private String comboId;
    @SerializedName("combo_section")
    @Expose
    private String comboSection;
    @SerializedName("in_dish_id")
    @Expose
    private String inDishId;
    @SerializedName("dish_desription")
    @Expose
    private Object dishDesription;
    @SerializedName("st_price")
    @Expose
    private List<StPrice> stPrice = null;
    @SerializedName("max_qty_peruser")
    @Expose
    private String maxQtyPeruser;
    @SerializedName("out_of_stock")
    @Expose
    private String outOfStock;
    @SerializedName("non_veg_status")
    @Expose
    private String nonVegStatus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", restId='" + restId + '\'' +
                ", navType='" + navType + '\'' +
                ", menuID='" + menuID + '\'' +
                ", imagename='" + imagename + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", liveStatus='" + liveStatus + '\'' +
                ", liveMessage='" + liveMessage + '\'' +
                ", comboId='" + comboId + '\'' +
                ", comboSection='" + comboSection + '\'' +
                ", inDishId='" + inDishId + '\'' +
                ", dishDesription=" + dishDesription +
                ", stPrice=" + stPrice +
                ", maxQtyPeruser='" + maxQtyPeruser + '\'' +
                ", outOfStock='" + outOfStock + '\'' +
                ", nonVegStatus='" + nonVegStatus + '\'' +
                '}';
    }

    public String getRestId() {
        return restId;
    }

    public void setRestId(String restId) {
        this.restId = restId;
    }

    public String getNavType() {
        return navType;
    }

    public void setNavType(String navType) {
        this.navType = navType;
    }

    public String getMenuID() {
        return menuID;
    }

    public void setMenuID(String menuID) {
        this.menuID = menuID;
    }

    public String getImagename() {
        return imagename;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getLiveStatus() {
        return liveStatus;
    }

    public void setLiveStatus(String liveStatus) {
        this.liveStatus = liveStatus;
    }

    public String getLiveMessage() {
        return liveMessage;
    }

    public void setLiveMessage(String liveMessage) {
        this.liveMessage = liveMessage;
    }

    public String getComboId() {
        return comboId;
    }

    public void setComboId(String comboId) {
        this.comboId = comboId;
    }

    public String getComboSection() {
        return comboSection;
    }

    public void setComboSection(String comboSection) {
        this.comboSection = comboSection;
    }

    public String getInDishId() {
        return inDishId;
    }

    public void setInDishId(String inDishId) {
        this.inDishId = inDishId;
    }

    public Object getDishDesription() {
        return dishDesription;
    }

    public void setDishDesription(Object dishDesription) {
        this.dishDesription = dishDesription;
    }

    public List<StPrice> getStPrice() {
        return stPrice;
    }

    public void setStPrice(List<StPrice> stPrice) {
        this.stPrice = stPrice;
    }

    public String getMaxQtyPeruser() {
        return maxQtyPeruser;
    }

    public void setMaxQtyPeruser(String maxQtyPeruser) {
        this.maxQtyPeruser = maxQtyPeruser;
    }

    public String getOutOfStock() {
        return outOfStock;
    }

    public void setOutOfStock(String outOfStock) {
        this.outOfStock = outOfStock;
    }

    public String getNonVegStatus() {
        return nonVegStatus;
    }

    public void setNonVegStatus(String nonVegStatus) {
        this.nonVegStatus = nonVegStatus;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}
