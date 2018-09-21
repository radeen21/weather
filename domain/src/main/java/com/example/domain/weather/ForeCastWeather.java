package com.example.domain.weather;

public class ForeCastWeather {

    private Locations location;

    private Currents current;

    private Forecasts forecasts;

    public Locations getLocation() {
        return location;
    }

    public Currents getCurrent() {
        return current;
    }

    public Forecasts getForecasts() {
        return forecasts;
    }

    public void setLocation(Locations location) {
        this.location = location;
    }

    public void setCurrent(Currents current) {
        this.current = current;
    }

    public void setForecasts(Forecasts forecasts) {
        this.forecasts = forecasts;
    }
}
