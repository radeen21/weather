package com.example.domain.weather;

import java.util.ArrayList;
import java.util.List;

public class Forecasts {

    private ArrayList<Forecastday> forecastday;

    public ArrayList<Forecastday> getForecastday() {
        return forecastday;
    }

    public void setForecastday(ArrayList<Forecastday> forecastday) {
        this.forecastday = forecastday;
    }
}
