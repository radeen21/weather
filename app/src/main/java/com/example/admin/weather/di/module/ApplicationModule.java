package com.example.admin.weather.di.module;

import android.app.Application;
import android.content.Context;

import com.example.data.weather.repository.WeatherEntityRepository;
import com.example.domain.weather.repository.LocationsRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    LocationsRepository provideLocationsRepository(WeatherEntityRepository weatherEntityRepository) {
        return weatherEntityRepository;
    }

}
