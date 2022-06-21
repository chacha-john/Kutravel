
package com.chachaup.kutravel.model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Venue {

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
    @SerializedName("postalCode")
    @Expose
    private String postalCode;
    @SerializedName("timezone")
    @Expose
    private String timezone;
    @SerializedName("city")
    @Expose
    private City city;
    @SerializedName("state")
    @Expose
    private State state;
    @SerializedName("country")
    @Expose
    private Country country;
    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("markets")
    @Expose
    private List<Market> markets = null;
    @SerializedName("dmas")
    @Expose
    private List<Dma> dmas = null;
    @SerializedName("upcomingEvents")
    @Expose
    private UpcomingEvents upcomingEvents;
    @SerializedName("ada")
    @Expose
    private Ada ada;
    @SerializedName("_links")
    @Expose
    private Links links;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Venue() {
    }

    /**
     * 
     * @param country
     * @param address
     * @param test
     * @param city
     * @param timezone
     * @param upcomingEvents
     * @param postalCode
     * @param type
     * @param locale
     * @param url
     * @param markets
     * @param dmas
     * @param name
     * @param location
     * @param links
     * @param id
     * @param state
     * @param ada
     */
    public Venue(String name, String type, String id, Boolean test, String url, String locale, String postalCode, String timezone, City city, State state, Country country, Address address, Location location, List<Market> markets, List<Dma> dmas, UpcomingEvents upcomingEvents, Ada ada, Links links) {
        super();
        this.name = name;
        this.type = type;
        this.id = id;
        this.test = test;
        this.url = url;
        this.locale = locale;
        this.postalCode = postalCode;
        this.timezone = timezone;
        this.city = city;
        this.state = state;
        this.country = country;
        this.address = address;
        this.location = location;
        this.markets = markets;
        this.dmas = dmas;
        this.upcomingEvents = upcomingEvents;
        this.ada = ada;
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

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Market> getMarkets() {
        return markets;
    }

    public void setMarkets(List<Market> markets) {
        this.markets = markets;
    }

    public List<Dma> getDmas() {
        return dmas;
    }

    public void setDmas(List<Dma> dmas) {
        this.dmas = dmas;
    }

    public UpcomingEvents getUpcomingEvents() {
        return upcomingEvents;
    }

    public void setUpcomingEvents(UpcomingEvents upcomingEvents) {
        this.upcomingEvents = upcomingEvents;
    }

    public Ada getAda() {
        return ada;
    }

    public void setAda(Ada ada) {
        this.ada = ada;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

}
