
package com.chachaup.kutravel.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Start {

    @SerializedName("localDate")
    @Expose
    private String localDate;
    @SerializedName("localTime")
    @Expose
    private String localTime;
    @SerializedName("dateTime")
    @Expose
    private String dateTime;
    @SerializedName("dateTBD")
    @Expose
    private Boolean dateTBD;
    @SerializedName("dateTBA")
    @Expose
    private Boolean dateTBA;
    @SerializedName("timeTBA")
    @Expose
    private Boolean timeTBA;
    @SerializedName("noSpecificTime")
    @Expose
    private Boolean noSpecificTime;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Start() {
    }

    /**
     * 
     * @param dateTime
     * @param localTime
     * @param dateTBA
     * @param noSpecificTime
     * @param timeTBA
     * @param localDate
     * @param dateTBD
     */
    public Start(String localDate, String localTime, String dateTime, Boolean dateTBD, Boolean dateTBA, Boolean timeTBA, Boolean noSpecificTime) {
        super();
        this.localDate = localDate;
        this.localTime = localTime;
        this.dateTime = dateTime;
        this.dateTBD = dateTBD;
        this.dateTBA = dateTBA;
        this.timeTBA = timeTBA;
        this.noSpecificTime = noSpecificTime;
    }

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
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

    public Boolean getDateTBD() {
        return dateTBD;
    }

    public void setDateTBD(Boolean dateTBD) {
        this.dateTBD = dateTBD;
    }

    public Boolean getDateTBA() {
        return dateTBA;
    }

    public void setDateTBA(Boolean dateTBA) {
        this.dateTBA = dateTBA;
    }

    public Boolean getTimeTBA() {
        return timeTBA;
    }

    public void setTimeTBA(Boolean timeTBA) {
        this.timeTBA = timeTBA;
    }

    public Boolean getNoSpecificTime() {
        return noSpecificTime;
    }

    public void setNoSpecificTime(Boolean noSpecificTime) {
        this.noSpecificTime = noSpecificTime;
    }

}
