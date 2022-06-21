
package com.chachaup.kutravel.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class VenueSearchResponse {

    @SerializedName("_embedded")
    @Expose
    private Embedded embedded;

    /**
     * No args constructor for use in serialization
     * 
     */
    public VenueSearchResponse() {
    }

    /**
     * 
     * @param embedded
     */
    public VenueSearchResponse(Embedded embedded) {
        super();
        this.embedded = embedded;
    }

    public Embedded getEmbedded() {
        return embedded;
    }

    public void setEmbedded(Embedded embedded) {
        this.embedded = embedded;
    }

}
