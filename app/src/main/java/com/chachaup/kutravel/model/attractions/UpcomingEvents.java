
package com.chachaup.kutravel.model.attractions;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class UpcomingEvents {

    @SerializedName("_total")
    @Expose
    private Integer total;
    @SerializedName("mfx-nl")
    @Expose
    private Integer mfxNl;
    @SerializedName("tmr")
    @Expose
    private Integer tmr;
    @SerializedName("mfx-de")
    @Expose
    private Integer mfxDe;
    @SerializedName("mfx-es")
    @Expose
    private Integer mfxEs;
    @SerializedName("ticketmaster")
    @Expose
    private Integer ticketmaster;
    @SerializedName("mfx-cz")
    @Expose
    private Integer mfxCz;
    @SerializedName("_filtered")
    @Expose
    private Integer filtered;
    @SerializedName("mfx-se")
    @Expose
    private Integer mfxSe;

    /**
     * No args constructor for use in serialization
     * 
     */
    public UpcomingEvents() {
    }

    /**
     * 
     * @param mfxDe
     * @param mfxSe
     * @param total
     * @param filtered
     * @param mfxCz
     * @param tmr
     * @param ticketmaster
     * @param mfxNl
     * @param mfxEs
     */
    public UpcomingEvents(Integer total, Integer mfxNl, Integer tmr, Integer mfxDe, Integer mfxEs, Integer ticketmaster, Integer mfxCz, Integer filtered, Integer mfxSe) {
        super();
        this.total = total;
        this.mfxNl = mfxNl;
        this.tmr = tmr;
        this.mfxDe = mfxDe;
        this.mfxEs = mfxEs;
        this.ticketmaster = ticketmaster;
        this.mfxCz = mfxCz;
        this.filtered = filtered;
        this.mfxSe = mfxSe;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getMfxNl() {
        return mfxNl;
    }

    public void setMfxNl(Integer mfxNl) {
        this.mfxNl = mfxNl;
    }

    public Integer getTmr() {
        return tmr;
    }

    public void setTmr(Integer tmr) {
        this.tmr = tmr;
    }

    public Integer getMfxDe() {
        return mfxDe;
    }

    public void setMfxDe(Integer mfxDe) {
        this.mfxDe = mfxDe;
    }

    public Integer getMfxEs() {
        return mfxEs;
    }

    public void setMfxEs(Integer mfxEs) {
        this.mfxEs = mfxEs;
    }

    public Integer getTicketmaster() {
        return ticketmaster;
    }

    public void setTicketmaster(Integer ticketmaster) {
        this.ticketmaster = ticketmaster;
    }

    public Integer getMfxCz() {
        return mfxCz;
    }

    public void setMfxCz(Integer mfxCz) {
        this.mfxCz = mfxCz;
    }

    public Integer getFiltered() {
        return filtered;
    }

    public void setFiltered(Integer filtered) {
        this.filtered = filtered;
    }

    public Integer getMfxSe() {
        return mfxSe;
    }

    public void setMfxSe(Integer mfxSe) {
        this.mfxSe = mfxSe;
    }

}
