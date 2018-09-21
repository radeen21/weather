package com.example.data.weather.repository.source;

import com.example.data.weather.WeatherEntity;

import rx.Observable;


public interface WeatherEntityDatas {

    Observable<WeatherEntity> getWeather();

}
