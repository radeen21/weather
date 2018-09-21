package com.example.data.weather.repository;

import com.example.data.weather.WeatherEntity;
import com.example.data.weather.mapper.WeatherEntityMapper;
import com.example.data.weather.repository.source.WeatherEntityDataFactory;
import com.example.domain.weather.Locations;
import com.example.domain.weather.repository.LocationsRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.functions.Func1;

@Singleton
public class WeatherEntityRepository implements LocationsRepository {

    private WeatherEntityDataFactory weatherEntityDataFactory;

    private WeatherEntityMapper weatherEntityMapper;

    @Inject
    public WeatherEntityRepository(WeatherEntityDataFactory weatherEntityDataFactory,
                                   WeatherEntityMapper weatherEntityMapper) {
        this.weatherEntityDataFactory = weatherEntityDataFactory;
        this.weatherEntityMapper = weatherEntityMapper;

    }

    @Override
    public Observable<Locations> locationsObservable() {
        return weatherEntityDataFactory.createData().getWeather()
                .startWith(Observable.just(new WeatherEntity()))
                .map(weatherEntity -> weatherEntityMapper
                         .transform(weatherEntity));
    }
}
