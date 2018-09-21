package com.example.admin.weather.di.module;


import com.example.admin.weather.di.scope.PerActivity;
import com.example.domain.weather.GetWeather;
import com.example.domain.weather.repository.LocationsRepository;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class WeatherModule {

    @Provides
    @PerActivity
    @Named("getForeCastWeather")
        GetWeather provideWeather(LocationsRepository promoRepository) {
            return new GetWeather(promoRepository);
    }

}
