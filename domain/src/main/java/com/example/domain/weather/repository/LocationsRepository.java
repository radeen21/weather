package com.example.domain.weather.repository;

import com.example.domain.weather.ForeCastWeather;
import com.example.domain.weather.Locations;

import java.util.List;

import rx.Observable;

public interface LocationsRepository {

//    Observable<Locations> forecastWeatherObservable();

    Observable<ForeCastWeather> forecastWeatherObservable();

}
