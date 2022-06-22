
package com.chachaup.kutravel.model.attractions;

import java.util.List;
import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class ExternalLinks {

    @SerializedName("youtube")
    @Expose
    private List<Youtube> youtube = null;
    @SerializedName("twitter")
    @Expose
    private List<Twitter> twitter = null;
    @SerializedName("itunes")
    @Expose
    private List<Itune> itunes = null;
    @SerializedName("lastfm")
    @Expose
    private List<Lastfm> lastfm = null;
    @SerializedName("facebook")
    @Expose
    private List<Facebook> facebook = null;
    @SerializedName("wiki")
    @Expose
    private List<Wiki> wiki = null;
    @SerializedName("spotify")
    @Expose
    private List<Spotify> spotify = null;
    @SerializedName("instagram")
    @Expose
    private List<Instagram> instagram = null;
    @SerializedName("musicbrainz")
    @Expose
    private List<Musicbrainz> musicbrainz = null;
    @SerializedName("homepage")
    @Expose
    private List<Homepage> homepage = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ExternalLinks() {
    }

    /**
     * 
     * @param youtube
     * @param twitter
     * @param itunes
     * @param lastfm
     * @param facebook
     * @param wiki
     * @param spotify
     * @param instagram
     * @param musicbrainz
     * @param homepage
     */
    public ExternalLinks(List<Youtube> youtube, List<Twitter> twitter, List<Itune> itunes, List<Lastfm> lastfm, List<Facebook> facebook, List<Wiki> wiki, List<Spotify> spotify, List<Instagram> instagram, List<Musicbrainz> musicbrainz, List<Homepage> homepage) {
        super();
        this.youtube = youtube;
        this.twitter = twitter;
        this.itunes = itunes;
        this.lastfm = lastfm;
        this.facebook = facebook;
        this.wiki = wiki;
        this.spotify = spotify;
        this.instagram = instagram;
        this.musicbrainz = musicbrainz;
        this.homepage = homepage;
    }

    public List<Youtube> getYoutube() {
        return youtube;
    }

    public void setYoutube(List<Youtube> youtube) {
        this.youtube = youtube;
    }

    public List<Twitter> getTwitter() {
        return twitter;
    }

    public void setTwitter(List<Twitter> twitter) {
        this.twitter = twitter;
    }

    public List<Itune> getItunes() {
        return itunes;
    }

    public void setItunes(List<Itune> itunes) {
        this.itunes = itunes;
    }

    public List<Lastfm> getLastfm() {
        return lastfm;
    }

    public void setLastfm(List<Lastfm> lastfm) {
        this.lastfm = lastfm;
    }

    public List<Facebook> getFacebook() {
        return facebook;
    }

    public void setFacebook(List<Facebook> facebook) {
        this.facebook = facebook;
    }

    public List<Wiki> getWiki() {
        return wiki;
    }

    public void setWiki(List<Wiki> wiki) {
        this.wiki = wiki;
    }

    public List<Spotify> getSpotify() {
        return spotify;
    }

    public void setSpotify(List<Spotify> spotify) {
        this.spotify = spotify;
    }

    public List<Instagram> getInstagram() {
        return instagram;
    }

    public void setInstagram(List<Instagram> instagram) {
        this.instagram = instagram;
    }

    public List<Musicbrainz> getMusicbrainz() {
        return musicbrainz;
    }

    public void setMusicbrainz(List<Musicbrainz> musicbrainz) {
        this.musicbrainz = musicbrainz;
    }

    public List<Homepage> getHomepage() {
        return homepage;
    }

    public void setHomepage(List<Homepage> homepage) {
        this.homepage = homepage;
    }

}
