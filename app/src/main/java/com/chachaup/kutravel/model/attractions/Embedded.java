
package com.chachaup.kutravel.model.attractions;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Embedded {

    @SerializedName("attractions")
    @Expose
    private List<Attraction> attractions = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Embedded() {
    }

    /**
     * 
     * @param attractions
     */
    public Embedded(List<Attraction> attractions) {
        super();
        this.attractions = attractions;
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
    }

}
