
package com.nayanatech.nayanarestaurant.Model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DashboardModel implements Serializable {

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("app-version")
    @Expose
    private String appVersion;

    @SerializedName("update-required")
    @Expose
    private Integer updateRequired;

    @SerializedName("baseURL")
    @Expose
    private String baseURL;

    @SerializedName("image_baseURL")
    @Expose
    private String imageBaseURL;

    @SerializedName("endpoints")
    @Expose
    private List<String> endpoints = null;

    @SerializedName("sections")
    @Expose
    private List<Section> sections = null;

    @SerializedName("alltimings")
    @Expose
    private Alltimings alltimings;

    @SerializedName("rest_details")
    @Expose
    private List<Object> restDetails = null;

    @SerializedName("offer_details")
    @Expose
    private List<Object> offerDetails = null;

    @SerializedName("type_details")
    @Expose
    private TypeDetails typeDetails;

    @SerializedName("open_close_status")
    @Expose
    private OpenCloseStatus openCloseStatus;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public Integer getUpdateRequired() {
        return updateRequired;
    }

    public void setUpdateRequired(Integer updateRequired) {
        this.updateRequired = updateRequired;
    }

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    public String getImageBaseURL() {
        return imageBaseURL;
    }

    public void setImageBaseURL(String imageBaseURL) {
        this.imageBaseURL = imageBaseURL;
    }

    public List<String> getEndpoints() {
        return endpoints;
    }

    public void setEndpoints(List<String> endpoints) {
        this.endpoints = endpoints;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public Alltimings getAlltimings() {
        return alltimings;
    }

    public void setAlltimings(Alltimings alltimings) {
        this.alltimings = alltimings;
    }

    public List<Object> getRestDetails() {
        return restDetails;
    }

    public void setRestDetails(List<Object> restDetails) {
        this.restDetails = restDetails;
    }

    public List<Object> getOfferDetails() {
        return offerDetails;
    }

    public void setOfferDetails(List<Object> offerDetails) {
        this.offerDetails = offerDetails;
    }

    public TypeDetails getTypeDetails() {
        return typeDetails;
    }

    public void setTypeDetails(TypeDetails typeDetails) {
        this.typeDetails = typeDetails;
    }

    public OpenCloseStatus getOpenCloseStatus() {
        return openCloseStatus;
    }

    public void setOpenCloseStatus(OpenCloseStatus openCloseStatus) {
        this.openCloseStatus = openCloseStatus;
    }

}
