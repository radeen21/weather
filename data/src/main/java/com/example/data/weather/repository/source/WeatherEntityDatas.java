package com.example.data.weather.repository.source;

import com.example.data.weather.WeatherEntity;
import com.example.data.weather.repository.source.network.response.WeatherInquiryResponse;

import rx.Observable;


public interface WeatherEntityDatas {

    Observable<WeatherInquiryResponse> getForecastWeather();

}
