
package com.chachaup.kutravel.model.attractions;

import java.util.List;
import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Attraction {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("test")
    @Expose
    private Boolean test;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("locale")
    @Expose
    private String locale;
    @SerializedName("externalLinks")
    @Expose
    private ExternalLinks externalLinks;
    @SerializedName("images")
    @Expose
    private List<Image> images = null;
    @SerializedName("classifications")
    @Expose
    private List<Classification> classifications = null;
    @SerializedName("upcomingEvents")
    @Expose
    private UpcomingEvents upcomingEvents;
    @SerializedName("_links")
    @Expose
    private Links links;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Attraction() {
    }

    /**
     * 
     * @param classifications
     * @param images
     * @param test
     * @param upcomingEvents
     * @param name
     * @param externalLinks
     * @param links
     * @param id
     * @param type
     * @param locale
     * @param url
     */
    public Attraction(String name, String type, String id, Boolean test, String url, String locale, ExternalLinks externalLinks, List<Image> images, List<Classification> classifications, UpcomingEvents upcomingEvents, Links links) {
        super();
        this.name = name;
        this.type = type;
        this.id = id;
        this.test = test;
        this.url = url;
        this.locale = locale;
        this.externalLinks = externalLinks;
        this.images = images;
        this.classifications = classifications;
        this.upcomingEvents = upcomingEvents;
        this.links = links;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getTest() {
        return test;
    }

    public void setTest(Boolean test) {
        this.test = test;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public ExternalLinks getExternalLinks() {
        return externalLinks;
    }

    public void setExternalLinks(ExternalLinks externalLinks) {
        this.externalLinks = externalLinks;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Classification> getClassifications() {
        return classifications;
    }

    public void setClassifications(List<Classification> classifications) {
        this.classifications = classifications;
    }

    public UpcomingEvents getUpcomingEvents() {
        return upcomingEvents;
    }

    public void setUpcomingEvents(UpcomingEvents upcomingEvents) {
        this.upcomingEvents = upcomingEvents;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

}
