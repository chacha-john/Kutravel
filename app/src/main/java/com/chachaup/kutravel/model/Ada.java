
package com.chachaup.kutravel.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Ada {

    @SerializedName("adaPhones")
    @Expose
    private String adaPhones;
    @SerializedName("adaCustomCopy")
    @Expose
    private String adaCustomCopy;
    @SerializedName("adaHours")
    @Expose
    private String adaHours;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Ada() {
    }

    /**
     * 
     * @param adaCustomCopy
     * @param adaPhones
     * @param adaHours
     */
    public Ada(String adaPhones, String adaCustomCopy, String adaHours) {
        super();
        this.adaPhones = adaPhones;
        this.adaCustomCopy = adaCustomCopy;
        this.adaHours = adaHours;
    }

    public String getAdaPhones() {
        return adaPhones;
    }

    public void setAdaPhones(String adaPhones) {
        this.adaPhones = adaPhones;
    }

    public String getAdaCustomCopy() {
        return adaCustomCopy;
    }

    public void setAdaCustomCopy(String adaCustomCopy) {
        this.adaCustomCopy = adaCustomCopy;
    }

    public String getAdaHours() {
        return adaHours;
    }

    public void setAdaHours(String adaHours) {
        this.adaHours = adaHours;
    }

}
