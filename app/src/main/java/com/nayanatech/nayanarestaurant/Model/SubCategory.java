
package com.nayanatech.nayanarestaurant.Model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubCategory implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("product_count")
    @Expose
    private String productCount;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("parent")
    @Expose
    private String parent;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("child_subcat")
    @Expose
    private List<ChildSubcat> childSubcat = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductCount() {
        return productCount;
    }

    public void setProductCount(String productCount) {
        this.productCount = productCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<ChildSubcat> getChildSubcat() {
        return childSubcat;
    }

    public void setChildSubcat(List<ChildSubcat> childSubcat) {
        this.childSubcat = childSubcat;
    }

}
