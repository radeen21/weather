package com.example.data.weather.mapper;

import com.example.data.weather.repository.source.network.response.WeatherInquiryResponse;
import com.example.domain.weather.ForeCastWeather;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class WeatherEntityMapper {

    @Inject
    public WeatherEntityMapper() {
    }

    public ForeCastWeather transform(WeatherInquiryResponse weatherEntity) {
        ForeCastWeather foreCastWeather = null;

        if (weatherEntity != null) {
            foreCastWeather = new ForeCastWeather();
            foreCastWeather.setLocation(weatherEntity.getLocation());
            foreCastWeather.setCurrent(weatherEntity.getCurrent());
            foreCastWeather.setForecasts(weatherEntity.getForecast());
        }

        return foreCastWeather;

    }
}
