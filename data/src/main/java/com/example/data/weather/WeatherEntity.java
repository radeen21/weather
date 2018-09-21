package com.example.data.weather;

import com.example.data.weather.model.Current;
import com.example.data.weather.model.Forecast;
import com.example.data.weather.model.Location;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherEntity {

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
