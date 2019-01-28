
package com.nayanatech.nayanarestaurant.Model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GroceryCatagories implements Serializable {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("categories")
    @Expose
    private List<Category> categories = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

}
