package com.example.data.weather.repository.source.network.response;

import com.example.data.weather.WeatherEntity;
import com.example.data.weather.model.Current;
import com.example.data.weather.model.Forecast;
import com.example.data.weather.model.Location;
import com.example.domain.weather.Currents;
import com.example.domain.weather.Forecasts;
import com.example.domain.weather.Locations;

import java.util.List;

public class WeatherInquiryResponse  {

    private Locations location;

    private Currents current;

    private Forecasts forecast;

    public Locations getLocation() {
        return location;
    }

    public Currents getCurrent() {
        return current;
    }

    public Forecasts getForecast() {
        return forecast;
    }



}
