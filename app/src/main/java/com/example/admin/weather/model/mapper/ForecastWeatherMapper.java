package com.example.admin.weather.model.mapper;

import com.example.admin.weather.di.scope.PerActivity;
import com.example.admin.weather.model.ForecastWeatherModel;
import com.example.domain.weather.ForeCastWeather;

import javax.inject.Inject;

@PerActivity
public class ForecastWeatherMapper {


    @Inject
    public ForecastWeatherMapper() {

    }

    public ForecastWeatherModel transform(ForeCastWeather foreCastWeather) {
        ForecastWeatherModel forecastWeatherModel = null;

        if (foreCastWeather != null) {
            forecastWeatherModel = new ForecastWeatherModel();

            forecastWeatherModel.setForecastday(foreCastWeather.getForecasts().getForecastday());
        }

        return forecastWeatherModel;
    }
}
