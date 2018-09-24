package com.example.admin.weather.model;

import com.example.domain.weather.Forecastday;

import java.util.List;

public class ForecastWeatherModel {

    private List<Forecastday> forecastday;

    public List<Forecastday> getForecastday() {
        return forecastday;
    }

    public void setForecastday(List<Forecastday> forecastday) {
        this.forecastday = forecastday;
    }
}
