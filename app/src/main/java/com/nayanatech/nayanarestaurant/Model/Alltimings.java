
package com.nayanatech.nayanarestaurant.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Alltimings {

    @SerializedName("lunch_start")
    @Expose
    private String lunchStart;
    @SerializedName("lunch_end")
    @Expose
    private String lunchEnd;
    @SerializedName("dinner_start")
    @Expose
    private String dinnerStart;
    @SerializedName("dinner_end")
    @Expose
    private String dinnerEnd;
    @SerializedName("breakfast_start")
    @Expose
    private String breakfastStart;
    @SerializedName("breakfast_end")
    @Expose
    private String breakfastEnd;
    @SerializedName("tiffin_start")
    @Expose
    private String tiffinStart;
    @SerializedName("tiffin_end")
    @Expose
    private String tiffinEnd;
    @SerializedName("fastfood_start")
    @Expose
    private String fastfoodStart;
    @SerializedName("fastfood_end")
    @Expose
    private String fastfoodEnd;
    @SerializedName("sweets_start")
    @Expose
    private String sweetsStart;
    @SerializedName("sweets_end")
    @Expose
    private String sweetsEnd;
    @SerializedName("fruits_start")
    @Expose
    private String fruitsStart;
    @SerializedName("fruits_end")
    @Expose
    private String fruitsEnd;

    public String getLunchStart() {
        return lunchStart;
    }

    public void setLunchStart(String lunchStart) {
        this.lunchStart = lunchStart;
    }

    public String getLunchEnd() {
        return lunchEnd;
    }

    public void setLunchEnd(String lunchEnd) {
        this.lunchEnd = lunchEnd;
    }

    public String getDinnerStart() {
        return dinnerStart;
    }

    public void setDinnerStart(String dinnerStart) {
        this.dinnerStart = dinnerStart;
    }

    public String getDinnerEnd() {
        return dinnerEnd;
    }

    public void setDinnerEnd(String dinnerEnd) {
        this.dinnerEnd = dinnerEnd;
    }

    public String getBreakfastStart() {
        return breakfastStart;
    }

    public void setBreakfastStart(String breakfastStart) {
        this.breakfastStart = breakfastStart;
    }

    public String getBreakfastEnd() {
        return breakfastEnd;
    }

    public void setBreakfastEnd(String breakfastEnd) {
        this.breakfastEnd = breakfastEnd;
    }

    public String getTiffinStart() {
        return tiffinStart;
    }

    public void setTiffinStart(String tiffinStart) {
        this.tiffinStart = tiffinStart;
    }

    public String getTiffinEnd() {
        return tiffinEnd;
    }

    public void setTiffinEnd(String tiffinEnd) {
        this.tiffinEnd = tiffinEnd;
    }

    public String getFastfoodStart() {
        return fastfoodStart;
    }

    public void setFastfoodStart(String fastfoodStart) {
        this.fastfoodStart = fastfoodStart;
    }

    public String getFastfoodEnd() {
        return fastfoodEnd;
    }

    public void setFastfoodEnd(String fastfoodEnd) {
        this.fastfoodEnd = fastfoodEnd;
    }

    public String getSweetsStart() {
        return sweetsStart;
    }

    public void setSweetsStart(String sweetsStart) {
        this.sweetsStart = sweetsStart;
    }

    public String getSweetsEnd() {
        return sweetsEnd;
    }

    public void setSweetsEnd(String sweetsEnd) {
        this.sweetsEnd = sweetsEnd;
    }

    public String getFruitsStart() {
        return fruitsStart;
    }

    public void setFruitsStart(String fruitsStart) {
        this.fruitsStart = fruitsStart;
    }

    public String getFruitsEnd() {
        return fruitsEnd;
    }

    public void setFruitsEnd(String fruitsEnd) {
        this.fruitsEnd = fruitsEnd;
    }

}
