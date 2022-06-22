package com.chachaup.kutravel.network;

import com.chachaup.kutravel.model.attractions.Attraction;
import com.chachaup.kutravel.model.attractions.AttractionSearchResponse;
import com.chachaup.kutravel.model.events.EventSearchResponse;
import com.chachaup.kutravel.model.venues.VenueSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {
    @GET("events")
    Call<EventSearchResponse> getEvents(
        @Query("keyword") String keyword,
        @Query("countryCode") String country,
        @Query("apikey") String apiKey
    );

    @GET("attractions")
    Call<AttractionSearchResponse> getAttractions(
            @Query("keyword") String keyword,
            @Query("apikey") String apiKey
    );

    @GET("venues")
    Call<VenueSearchResponse> getVenues(
            @Query("keyword") String keyword,
            @Query("countryCode") String country,
            @Query("apikey") String apiKey
    );
}
