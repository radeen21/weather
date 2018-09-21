package com.example.data.weather.repository.source.network;

import com.example.data.weather.repository.source.network.response.WeatherInquiryResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface WeatherApi {

    @GET("v1/forecast.json")
    Observable<WeatherInquiryResponse> getForecastWeather(@Query("key") String key,
                                                    @Query("q") String q,
                                                    @Query("days") int days);
}
