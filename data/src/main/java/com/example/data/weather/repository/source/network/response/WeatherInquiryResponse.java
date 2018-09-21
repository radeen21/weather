package com.example.data.weather.repository.source.network.response;

import com.example.data.weather.WeatherEntity;
import com.example.data.weather.model.Current;
import com.example.data.weather.model.Forecast;
import com.example.data.weather.model.Location;

import java.util.List;

public class WeatherInquiryResponse  {

    private Location location;

    private Current current;

    private Forecast forecast;

    public Location getLocation() {
        return location;
    }

    public Current getCurrent() {
        return current;
    }

    public Forecast getForecast() {
        return forecast;
    }

}
