
package com.chachaup.kutravel.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Public {

    @SerializedName("startDateTime")
    @Expose
    private String startDateTime;
    @SerializedName("startTBD")
    @Expose
    private Boolean startTBD;
    @SerializedName("startTBA")
    @Expose
    private Boolean startTBA;
    @SerializedName("endDateTime")
    @Expose
    private String endDateTime;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Public() {
    }

    /**
     * 
     * @param startDateTime
     * @param startTBD
     * @param endDateTime
     * @param startTBA
     */
    public Public(String startDateTime, Boolean startTBD, Boolean startTBA, String endDateTime) {
        super();
        this.startDateTime = startDateTime;
        this.startTBD = startTBD;
        this.startTBA = startTBA;
        this.endDateTime = endDateTime;
    }

    public String getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(String startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Boolean getStartTBD() {
        return startTBD;
    }

    public void setStartTBD(Boolean startTBD) {
        this.startTBD = startTBD;
    }

    public Boolean getStartTBA() {
        return startTBA;
    }

    public void setStartTBA(Boolean startTBA) {
        this.startTBA = startTBA;
    }

    public String getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(String endDateTime) {
        this.endDateTime = endDateTime;
    }

}
