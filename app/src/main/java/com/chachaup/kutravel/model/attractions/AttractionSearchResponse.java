
package com.chachaup.kutravel.model.attractions;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class AttractionSearchResponse {

    @SerializedName("_embedded")
    @Expose
    private Embedded embedded;

    /**
     * No args constructor for use in serialization
     * 
     */
    public AttractionSearchResponse() {
    }

    /**
     * 
     * @param embedded
     */
    public AttractionSearchResponse(Embedded embedded) {
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
