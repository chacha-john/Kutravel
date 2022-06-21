package com.chachaup.kutravel.network;

import com.chachaup.kutravel.model.Attraction;
import com.chachaup.kutravel.model.Event;
import com.chachaup.kutravel.model.Venue;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface API {
    @GET("events")
    Call<Event> getEvents(
        @Query("keyword") String keyword,
        @Query("countryCode") String country,
        @Query("apikey") String apiKey
    );

    @GET("attractions")
    Call<Attraction> getAttractions(
            @Query("keyword") String keyword
    );

    @GET("venues")
    Call<Venue> getVenues(
            @Query("keyword") String keyword,
            @Query("countryCode") String country
    );
}
