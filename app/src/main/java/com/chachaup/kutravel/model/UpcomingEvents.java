
package com.chachaup.kutravel.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class UpcomingEvents {

    @SerializedName("_total")
    @Expose
    private Integer total;
    @SerializedName("ticketmaster")
    @Expose
    private Integer ticketmaster;
    @SerializedName("_filtered")
    @Expose
    private Integer filtered;

    /**
     * No args constructor for use in serialization
     * 
     */
    public UpcomingEvents() {
    }

    /**
     * 
     * @param total
     * @param filtered
     * @param ticketmaster
     */
    public UpcomingEvents(Integer total, Integer ticketmaster, Integer filtered) {
        super();
        this.total = total;
        this.ticketmaster = ticketmaster;
        this.filtered = filtered;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTicketmaster() {
        return ticketmaster;
    }

    public void setTicketmaster(Integer ticketmaster) {
        this.ticketmaster = ticketmaster;
    }

    public Integer getFiltered() {
        return filtered;
    }

    public void setFiltered(Integer filtered) {
        this.filtered = filtered;
    }

}
