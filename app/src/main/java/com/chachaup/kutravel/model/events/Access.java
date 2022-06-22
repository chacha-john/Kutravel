
package com.chachaup.kutravel.model.events;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Access {

    @SerializedName("startDateTime")
    @Expose
    private String startDateTime;
    @SerializedName("startApproximate")
    @Expose
    private Boolean startApproximate;
    @SerializedName("endDateTime")
    @Expose
    private String endDateTime;
    @SerializedName("endApproximate")
    @Expose
    private Boolean endApproximate;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Access() {
    }

    /**
     * 
     * @param startDateTime
     * @param startApproximate
     * @param endApproximate
     * @param endDateTime
     */
    public Access(String startDateTime, Boolean startApproximate, String endDateTime, Boolean endApproximate) {
        super();
        this.startDateTime = startDateTime;
        this.startApproximate = startApproximate;
        this.endDateTime = endDateTime;
        this.endApproximate = endApproximate;
    }

    public String getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(String startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Boolean getStartApproximate() {
        return startApproximate;
    }

    public void setStartApproximate(Boolean startApproximate) {
        this.startApproximate = startApproximate;
    }

    public String getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(String endDateTime) {
        this.endDateTime = endDateTime;
    }

    public Boolean getEndApproximate() {
        return endApproximate;
    }

    public void setEndApproximate(Boolean endApproximate) {
        this.endApproximate = endApproximate;
    }

}
