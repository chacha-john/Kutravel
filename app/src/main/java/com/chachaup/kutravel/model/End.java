
package com.chachaup.kutravel.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class End {

    @SerializedName("localTime")
    @Expose
    private String localTime;
    @SerializedName("dateTime")
    @Expose
    private String dateTime;
    @SerializedName("approximate")
    @Expose
    private Boolean approximate;
    @SerializedName("noSpecificTime")
    @Expose
    private Boolean noSpecificTime;

    /**
     * No args constructor for use in serialization
     * 
     */
    public End() {
    }

    /**
     * 
     * @param dateTime
     * @param localTime
     * @param noSpecificTime
     * @param approximate
     */
    public End(String localTime, String dateTime, Boolean approximate, Boolean noSpecificTime) {
        super();
        this.localTime = localTime;
        this.dateTime = dateTime;
        this.approximate = approximate;
        this.noSpecificTime = noSpecificTime;
    }

    public String getLocalTime() {
        return localTime;
    }

    public void setLocalTime(String localTime) {
        this.localTime = localTime;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Boolean getApproximate() {
        return approximate;
    }

    public void setApproximate(Boolean approximate) {
        this.approximate = approximate;
    }

    public Boolean getNoSpecificTime() {
        return noSpecificTime;
    }

    public void setNoSpecificTime(Boolean noSpecificTime) {
        this.noSpecificTime = noSpecificTime;
    }

}
