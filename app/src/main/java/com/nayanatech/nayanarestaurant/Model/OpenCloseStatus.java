
package com.nayanatech.nayanarestaurant.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OpenCloseStatus {

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("openstatus")
    @Expose
    private String openstatus;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getOpenstatus() {
        return openstatus;
    }

    public void setOpenstatus(String openstatus) {
        this.openstatus = openstatus;
    }

}
